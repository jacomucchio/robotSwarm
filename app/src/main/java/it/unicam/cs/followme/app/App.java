package it.unicam.cs.followme.app;


import it.unicam.cs.pa.robotSwarm.model.Simulator;

public class App {
    public static void main(String[] args) {
        Simulator simulator = new Simulator(2);
        simulator.simulate(1,10);

    }
}
