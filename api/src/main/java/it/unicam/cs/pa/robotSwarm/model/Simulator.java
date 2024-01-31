package it.unicam.cs.pa.robotSwarm.model;
import it.unicam.cs.pa.robotSwarm.io.ParserManager;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Simulator implements ISimulator{
    private IEnvironment environment;

    /**
     * Constructs a simulator with the specified number of robots.
     *
     * @param robotNumber The number of robots in the simulation.
     */
    public Simulator(int robotNumber) {
        this.environment = generateEnvironment(robotNumber);
    }

    @Override
    public void simulate(double dt, double time) {
        setupSimulation();
        for (double currentTime = 0; currentTime <= time; currentTime += dt) {
            for (IRobot robot : environment.getRobots()) {
                robot.executeCommand();
                System.out.println(robot);
            }
            // eventualmente aggiorna l'ambiente
        }
    }
    /**
     * Generates an environment with the specified number of robots.
     *
     * @param robotNumber The number of robots to generate.
     * @return The generated environment.
     */
    public Environment generateEnvironment(int robotNumber)
    {
        return new Environment(generateRobots(robotNumber));
    }
    /**
     * Generates a list of robots with the specified number.
     *
     * @param robotNumber The number of robots to generate.
     * @return The list of generated robots.
     */
    public List<IRobot> generateRobots(int robotNumber)
    {
        List<IRobot> robots=new ArrayList<>();
        for(int i=0;i<robotNumber;i++)
        {
            robots.add(new Robot(-100,100,-100,100));
            System.out.println(robots.get(i));
        }
        return robots;
    }
    /**
     * Sets up the simulation by parsing robot instructions and area configurations.
     */
    public void setupSimulation(){
        //TODO sistemare in modo che il file venga letto da una cartella generica
        File rbtInstructionFile=
                Paths.get("src/main/java/it/unicam/cs/pa/robotSwarm/io/robotInstructions.txt").toFile();
        File areaConfigurationFile=
                Paths.get("src/main/java/it/unicam/cs/pa/robotSwarm/io/areasConfiguration.txt").toFile();

        ParserManager parserManager = new ParserManager(rbtInstructionFile,areaConfigurationFile,environment);
        parserManager.executeParsing();
    }

}
