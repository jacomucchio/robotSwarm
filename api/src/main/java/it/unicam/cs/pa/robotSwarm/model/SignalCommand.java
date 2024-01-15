package it.unicam.cs.pa.robotSwarm.model;

public class SignalCommand implements ICommand{
    private IRobot robot;
    public SignalCommand(IRobot robot) {
        this.robot=robot;
    }

    @Override
    public void execute() {
        robot.signal();
    }
}
