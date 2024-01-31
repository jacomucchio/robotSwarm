package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;
/**
 * Represents a command to stop the movement of a specific robot.
 */
public class StopCommand implements ICommand, Cloneable {
    private IRobot robot;
    private boolean isExecuted=false;

    /**
     * Constructs a StopCommand associated with a specific robot.
     *
     * @param robot The robot to stop.
     */
    public StopCommand(IRobot robot) {
        this.robot = robot;
    }

    /**
     * Constructs a StopCommand without associating it with any specific robot.
     */
    public StopCommand() {
    }

    /**
     * Executes the stop command, instructing the associated robot to stop its movement.
     */
    @Override
    public void execute() {
        robot.stop();
        isExecuted=true;
    }

    /**
     * Checks if the stop command has been executed.
     *
     * @return true if the command has been executed, false otherwise.
     */
    @Override
    public boolean isExecuted() {
        return isExecuted;
    }

    /**
     * Sets the receiver (robot) for the stop command.
     *
     * @param receiver The robot to set as the receiver.
     */
    @Override
    public void setReceiver(IRobot receiver) {
        this.robot=receiver;
    }
    @Override
    public StopCommand clone() {
        try {
            StopCommand clonedCommand = (StopCommand) super.clone();
            return clonedCommand;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
    @Override
    public String toString() {
        return "StopCommand [" +
                ", Executed: " + isExecuted +
                "]";
    }

}
