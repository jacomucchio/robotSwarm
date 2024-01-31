package it.unicam.cs.pa.robotSwarm.io;

import it.unicam.cs.pa.robotSwarm.io.ParserManager;
import it.unicam.cs.pa.robotSwarm.model.IEnvironment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
/**
 * The SimulationConfigurator class is responsible for setting up the simulation environment by
 * handling the loading of environment and commands files and initializing the ParserManager.
 */
public class SimulationConfigurator {
    /**
     * The environment to be configured for the simulation.
     */
    private IEnvironment environment;

    /**
     * Constructs a SimulationConfigurator with the specified environment.
     *
     * @param environment The environment to be configured for the simulation.
     */
    public SimulationConfigurator(IEnvironment environment) {
        this.environment = environment;
    }

    /**
     * Sets up the simulation environment by loading environment and command files and initializing the ParserManager.
     *
     */
    public void setupSimulation() {
        File rbtInstructionFile;
        File areaConfigurationFile;

        try {
            rbtInstructionFile = loadResourceAsTempFile("robotInstructions.txt", "robotInstructions", ".txt");
            areaConfigurationFile = loadResourceAsTempFile("areasConfiguration.txt", "areasConfiguration", ".txt");

            initializeParserManager(rbtInstructionFile, areaConfigurationFile);

        } catch (Exception e) {
            handleSetupError(e);
        }
    }
    /**
     * Creates a temporary file from the provided InputStream, with the specified prefix and suffix.
     *
     * @param inputStream The InputStream containing data for the temporary file.
     * @param prefix       The prefix for the temporary file.
     * @param suffix       The suffix for the temporary file.
     * @return The created temporary file.
     * @throws Exception If the InputStream is null or an error occurs during file creation or copying.
     */
    private File createTempFileFromResource(InputStream inputStream, String prefix, String suffix) throws Exception {
        if (inputStream == null) {
            throw new Exception("InputStream can't be null");
        }
        File tempFile = File.createTempFile(prefix, suffix);
        tempFile.deleteOnExit();
        try {
            Files.copy(inputStream, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new Exception("Error during the copy of data from InputStream to temporary file: " + e.getMessage());
        }
        return tempFile;
    }

    /**
     * Loads a resource as a temporary file with the specified name prefix and file extension.
     *
     * @param resourceName   The name of the resource to be loaded.
     * @param fileNamePrefix The prefix for the temporary file.
     * @param fileExtension  The extension for the temporary file.
     * @return The loaded resource as a temporary file.
     * @throws Exception If the resource is not found or an error occurs during loading.
     */
    private File loadResourceAsTempFile(String resourceName, String fileNamePrefix, String fileExtension) throws Exception {
        InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(resourceName);

        if (resourceStream == null) {
            System.err.println("File " + resourceName + " not found.");
            throw new FileNotFoundException("File " + resourceName + " not found.");
        }

        return createTempFileFromResource(resourceStream, fileNamePrefix, fileExtension);
    }

    /**
     * Initializes the ParserManager with the provided robot instruction and area configuration files.
     *
     * @param rbtInstructionFile    The file containing robot instructions.
     * @param areaConfigurationFile The file containing area configuration.
     */
    private void initializeParserManager(File rbtInstructionFile, File areaConfigurationFile) {
        ParserManager parserManager = new ParserManager(rbtInstructionFile, areaConfigurationFile, environment);
        parserManager.executeParsing();
    }

    /**
     * Handles errors that may occur during the simulation setup process.
     *
     * @param e The exception that occurred.
     */
    private void handleSetupError(Exception e) {
        System.err.println("Error during the reading or writing of temporary file: " + e.getMessage());
    }
}
