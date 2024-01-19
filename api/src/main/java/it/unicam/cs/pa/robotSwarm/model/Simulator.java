package it.unicam.cs.pa.robotSwarm.model;

import java.util.ArrayList;
import java.util.List;

public class Simulator implements ISimulator{
    private IEnvironment environment;

    public Simulator(IEnvironment environment) {
        this.environment = environment;
    }
    @Override
    public void simulate(double dt, double time) {
        for (double currentTime = 0; currentTime <= time; currentTime += dt) {
            for (IRobot robot : environment.getRobots()) {
                robot.executeCommand();
            }
            // eventualmente aggiorna l'ambiente
        }
    }

    public void setupEnvironment()
    {

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
}
