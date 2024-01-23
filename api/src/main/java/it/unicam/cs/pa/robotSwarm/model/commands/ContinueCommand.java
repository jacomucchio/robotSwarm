package it.unicam.cs.pa.robotSwarm.model.commands;
import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

/**
 * Represents a command to continue the execution of a robot's movement for a specified duration.
 */
public class ContinueCommand implements ICommand,Cloneable {
    private IRobot robot;
    private double seconds;
    private boolean isExecuted=false;

    public ContinueCommand(IRobot robot,double seconds) {
        if(seconds<0) throw new IllegalArgumentException("Seconds must be non-negative");
        this.robot = robot;
        this.seconds=seconds;
    }
    public ContinueCommand(double seconds) {
        if(seconds<0) throw new IllegalArgumentException("Seconds must be non-negative");
        this.seconds=seconds;
    }
    /**
     * Executes the continue command, allowing the robot to continue movement for the specified duration.
     *
     */
    @Override
    public void execute() {
        System.out.println("sto eseguendo continue" +seconds);
        if(seconds<robot.getExecutionTime())
        {
            robot.continueMove(seconds);
            isExecuted=true;
        } else {
            robot.continueMove(robot.getExecutionTime());
            seconds -= robot.getExecutionTime();
        }
    }

    @Override
    public boolean isExecuted() {
        return isExecuted;
    }

    @Override
    public void setReceiver(IRobot receiver) {
        this.robot=receiver;
    }

    @Override
    public ContinueCommand clone() {
        try {
            return (ContinueCommand) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

}
