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
        validateSeconds(seconds);
        this.robot = robot;
        this.seconds=seconds;
    }
    public ContinueCommand(double seconds) {
        validateSeconds(seconds);
        this.seconds=seconds;
    }
    /**
     * Executes the continue command, allowing the robot to continue movement for the specified duration.
     *
     */
    @Override
    public void execute() {
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

    @Override
    public String toString() {
        return "Continue ["
                + " Seconds: " + seconds
                + "]";
    }
    /**
     * Validates that the provided seconds value is non-negative.
     *
     * @param seconds The seconds value to validate.
     * @throws IllegalArgumentException if seconds is negative.
     */
    private void validateSeconds(double seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Seconds must be non-negative");
        }
    }
}
