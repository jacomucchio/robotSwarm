package it.unicam.cs.pa.robotSwarm.model;
import it.unicam.cs.pa.robotSwarm.io.SimulationConfigurator;

import java.util.ArrayList;
import java.util.List;


public class Simulator implements ISimulator{
    private IEnvironment environment;
    private final int robotNumber;
    /**
     * Constructs a simulator with the specified number of robots.
     *
     * @param robotNumber The number of robots in the simulation.
     */
    public Simulator(int robotNumber) {
        this.robotNumber=robotNumber;
    }

    @Override
    public void simulate(double dt, double time) {
        if(dt>time) throw new IllegalArgumentException("time must be greater than dt");
        if(dt<0) throw new IllegalArgumentException("time can't be a negative value");
        this.environment = generateEnvironment(robotNumber, dt);
        SimulationConfigurator sim = new SimulationConfigurator(environment);
        sim.setupSimulation();
        for (double currentTime = 0; currentTime <= time; currentTime += dt) {
            System.out.println("Starting Execution\n");
            for (IRobot robot : environment.getRobots()) {
                robot.executeCommand();
                System.out.println(robot+"\n");
            }
            System.out.println("Done Execution\n");
        }
    }
    /**
     * Generates an environment with the specified number of robots.
     *
     * @param robotNumber The number of robots to generate.
     * @return The generated environment.
     */
    public Environment generateEnvironment(int robotNumber,double dt)
    {
        return new Environment(generateRobots(robotNumber,dt));
    }

    /**
     * Generates a list of robots with the specified number.
     *
     * @param robotNumber The number of robots to generate.
     * @return The list of generated robots.
     */
    public List<IRobot> generateRobots(int robotNumber,double dt)
    {
        List<IRobot> robots=new ArrayList<>();
        for(int i=0;i<robotNumber;i++)
        {
            robots.add(new Robot(-100,100,-100,100,dt));
            System.out.println(robots.get(i));
        }
        return robots;
    }

    public IEnvironment getEnvironment(){return this.environment;}


}
