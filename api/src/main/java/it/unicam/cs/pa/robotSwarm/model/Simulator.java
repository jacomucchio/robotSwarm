package it.unicam.cs.pa.robotSwarm.model;

import it.unicam.cs.followme.utilities.FollowMeParser;
import it.unicam.cs.pa.robotSwarm.io.ParserHandler;

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
        System.out.println("L'environment contiene" +environment.getRobots().stream().toList());
        ParserHandler cmdParser = new ParserHandler(environment);
        FollowMeParser generalParser = new FollowMeParser(cmdParser);
        String fileName = "src/main/java/it/unicam/cs/pa/robotSwarm/io/robotInstructions.txt";
        File file = Paths.get(fileName).toFile();
        try {
            generalParser.parseRobotProgram(file);
            System.out.println("ho letto il file");
        } catch (Exception e) {
            e.printStackTrace();
            // Gestisci eventuali eccezioni qui
        }
    }
    /*
    public void executeParsing(Path programPath, Path areaPath){
        ParserHandler cmdParser = new ParserHandler(environment);
        //TODO aggiungere al parser anche il parser per le aree
        FollowMeParser parser = new FollowMeParser(cmdParser);
        parser.parseRobotProgram(programPath);
        parser.parseEnvironment(areaPath);
    }
    */

}
