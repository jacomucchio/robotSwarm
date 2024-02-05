package it.unicam.cs.followme.app;


import it.unicam.cs.pa.robotSwarm.model.Simulator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfRobots = 0;
        double timeInterval = 0.0;
        double totalTime = 0.0;

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter the number of robots: ");
            if (scanner.hasNextInt()) {
                numberOfRobots = scanner.nextInt();
                if(numberOfRobots>0) {
                    validInput = true;
                }else System.out.println("insert a positive value");
            } else {
                System.out.println("Invalid input. Please enter a valid integer or a positive value.");
                scanner.next();
            }
        }

        validInput = false;
        while (!validInput) {
            System.out.print("Enter the time for command execution: ");
            if (scanner.hasNextDouble()) {
                timeInterval = scanner.nextDouble();
                if(timeInterval>0){
                    validInput = true;
                }else System.out.println("insert a positive value");
            } else {
                System.out.println("Invalid input. Please enter a valid double");
                scanner.next();
            }
        }

        validInput = false;
        while (!validInput) {
            System.out.print("Enter the total duration of the simulation: ");
            if (scanner.hasNextDouble()) {
                totalTime = scanner.nextDouble();
                if(totalTime>timeInterval) {
                    validInput = true;
                }else System.out.println("insert a value greater than time interval");
            } else {
                System.out.println("Invalid input. Please enter a valid double.");
                scanner.next();
            }
        }

        Simulator simulator = new Simulator(numberOfRobots);
        simulator.simulate(timeInterval, totalTime);

        scanner.close();
    }


}
