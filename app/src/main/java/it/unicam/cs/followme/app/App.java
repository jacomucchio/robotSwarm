package it.unicam.cs.followme.app;


import it.unicam.cs.pa.robotSwarm.model.Simulator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of robots: ");
        int numberOfRobots = scanner.nextInt();
        Simulator simulator = new Simulator(numberOfRobots);
        System.out.print("Enter the time for command execution: ");
        double timeInterval = scanner.nextDouble();
        System.out.print("Enter the total duration of the simulation: ");
        double totalTime = scanner.nextDouble();
        simulator.simulate(timeInterval, totalTime);
        scanner.close();
    }

}
