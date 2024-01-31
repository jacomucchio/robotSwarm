package it.unicam.cs.pa.robotSwarm.io;

import it.unicam.cs.followme.utilities.FollowMeParser;
import it.unicam.cs.followme.utilities.ShapeData;
import it.unicam.cs.pa.robotSwarm.model.IArea;
import it.unicam.cs.pa.robotSwarm.model.IEnvironment;
import it.unicam.cs.pa.robotSwarm.model.ShapeDataAreaFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the parsing of robot programs and areas, assigning commands to robots in the given environment.
 */
public class ParserManager {
    // Path of the file containing the robot program.
    private File programPath;
    // Path of the file containing the areas.
    private File areasPath;
    private IEnvironment environment;

    private FollowMeParser parser;

    /**
     * Constructs a ParserManager with the specified program file, areas file, and environment.
     *
     * @param programPath Path of the file containing the robot program.
     * @param areasPath Path of the file containing the areas.
     * @param environment The environment where the robots operate.
     */
    public ParserManager(File programPath, File areasPath, IEnvironment environment) {
        this.programPath = programPath;
        this.areasPath = areasPath;
        this.environment=environment;
        parser = new FollowMeParser(new ProgramParserHandler(environment));
    }

    /**
     * Executes parsing for both the robot program and areas.
     */
    public void executeParsing(){
        executeProgramParsing();
        executeAreaParsing();
    }

    /**
     * Parses the robot program file and assigns commands to each robot in the environment.
     */
    private void executeProgramParsing(){
        try {
            parser.parseRobotProgram(programPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Parses the areas file and adds the created areas to the environment.
     */
    private void executeAreaParsing(){
        ShapeDataAreaFactory areaFactory = new ShapeDataAreaFactory();
        List<IArea> areas = new ArrayList<>();
        try {
            List<ShapeData> parsedShapeData = parser.parseEnvironment(areasPath);
            for (ShapeData shapeData : parsedShapeData) {
                areas.add(areaFactory.createArea(shapeData));
            }
            environment.addAreas(areas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
