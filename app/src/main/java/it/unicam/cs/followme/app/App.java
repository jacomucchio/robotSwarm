package it.unicam.cs.followme.app;


import it.unicam.cs.followme.utilities.FollowMeParser;
import it.unicam.cs.pa.robotSwarm.io.ProgramParserHandler;
import it.unicam.cs.pa.robotSwarm.model.Environment;
import it.unicam.cs.pa.robotSwarm.model.IRobot;
import it.unicam.cs.pa.robotSwarm.model.Robot;
import it.unicam.cs.pa.robotSwarm.model.Simulator;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Simulator simulator = new Simulator(2);
        simulator.simulate(1,10);
    }
}
