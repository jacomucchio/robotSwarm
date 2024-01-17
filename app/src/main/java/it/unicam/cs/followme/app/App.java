package it.unicam.cs.followme.app;


import it.unicam.cs.followme.utilities.FollowMeParser;
import it.unicam.cs.pa.robotSwarm.io.ParserHandler;
import it.unicam.cs.pa.robotSwarm.model.Environment;
import it.unicam.cs.pa.robotSwarm.model.Robot;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));

        Environment environment= new Environment();
        Robot robot = new Robot();
        ParserHandler handler = new ParserHandler(robot,environment);
        FollowMeParser parser = new FollowMeParser(handler);
        // Costruisci il percorso al file
        String fileName = "C:\\Users\\jacom\\IdeaProjects\\RobotSwarm\\api\\src\\main\\java\\it\\unicam\\cs\\pa\\robotSwarm\\io\\robotInstructions.txt";
        File file = Paths.get(fileName).toFile();
        try {
            parser.parseRobotProgram(file);
            System.out.println("ho letto il file");
        } catch (Exception e) {
            e.printStackTrace();
            // Gestisci eventuali eccezioni qui
        }
        robot.executeCommand();
        System.out.println("cosa :"+robot.getLabel());
    }
}
