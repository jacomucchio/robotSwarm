package it.unicam.cs.pa.robotSwarm.model;

public class UnsignalCommand implements ICommand{
    private IRobot robot;
    public UnsignalCommand(IRobot robot) {
        this.robot=robot;
    }

    @Override
    public void execute() {
        robot.unsignal();
    }
}
