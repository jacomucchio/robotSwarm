package it.unicam.cs.pa.robotSwarm.model;

public class StopCommand implements ICommand{
    private IRobot robot;
    public StopCommand(IRobot robot) {
        this.robot = robot;
    }
    @Override
    public void execute() {
        robot.stop();
    }
}
