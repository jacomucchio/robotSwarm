package it.unicam.cs.followme.app;


import it.unicam.cs.pa.robotSwarm.model.Simulator;

public class App {
    public static void main(String[] args) {
        int numberOfRobots = Integer.parseInt(args[0]);
        double dt = Double.parseDouble(args[1]);
        double totalTime = Double.parseDouble(args[2]);
        Simulator simulator = new Simulator(numberOfRobots);
        simulator.simulate(dt, totalTime);
    }
}
