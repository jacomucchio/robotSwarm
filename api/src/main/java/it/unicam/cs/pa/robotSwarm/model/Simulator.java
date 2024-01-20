package it.unicam.cs.pa.robotSwarm.model;

import it.unicam.cs.followme.utilities.FollowMeParser;
import it.unicam.cs.pa.robotSwarm.io.ParserManager;
import it.unicam.cs.pa.robotSwarm.io.ProgramParserHandler;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Simulator implements ISimulator{
    private IEnvironment environment;
    //TODO far si che il programma venga preso direttamente dalla directory specifica

    public Simulator(int robotNumber) {
        this.environment = generateEnvironment(robotNumber);
    }
    @Override
    public void simulate(double dt, double time) {
        setupSimulation();
        System.out.println(environment.getAreas().toString());
        for (double currentTime = 0; currentTime <= time; currentTime += dt) {
            System.out.println("esecuzione numero: "+currentTime);
            for (IRobot robot : environment.getRobots()) {
                robot.executeCommand();
            }
            // eventualmente aggiorna l'ambiente
        }
    }

    public Environment generateEnvironment(int robotNumber)
    {
        Environment env = new Environment(generateRobots(robotNumber));
        return env;
    }
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
    //TODO far si che setupSimulation faccia il parsing dei comandi e dell'ambiente
    public void setupSimulation(){
        File rbtInstructionFIle=
                Paths.get("src/main/java/it/unicam/cs/pa/robotSwarm/io/robotInstructions.txt").toFile();
        File areaConfigurationFile=
                Paths.get("src/main/java/it/unicam/cs/pa/robotSwarm/io/areasConfiguration.txt").toFile();
        ParserManager parserManager = new ParserManager(rbtInstructionFIle,areaConfigurationFile,environment);
        parserManager.executeParsing();
    }

}
