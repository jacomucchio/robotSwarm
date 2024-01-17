package it.unicam.cs.pa.robotSwarm.model;

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
}
