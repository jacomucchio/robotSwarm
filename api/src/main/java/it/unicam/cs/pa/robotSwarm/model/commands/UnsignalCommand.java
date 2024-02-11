package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.ILabel;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

/**
 * Represents a command to remove a signal associated with a specific label on a robot.
 */

public class UnsignalCommand implements ICommand,Cloneable {
    private IRobot robot;
    private ILabel label;
    private boolean isExecuted=false;

    /**
     * Constructs an UnsignalCommand associated with a specific robot and label.
     *
     * @param robot The robot to unsignal.
     * @param label The label to unsignal.
     */
    public UnsignalCommand(IRobot robot, ILabel label) {
        this.robot=robot;
        this.label=label;
    }

    /**
     * Constructs an UnsignalCommand without associating it with any specific robot.
     *
     * @param label The label to unsignal.
     */
    public UnsignalCommand(ILabel label) {
        this.label=label;
    }

    /**
     * Executes the unsignal command, removing the associated signal on the robot.
     */
    @Override
    public void execute() {
        robot.unsignal(label);
        isExecuted=true;
    }

    /**
     * Checks if the unsignal command has been executed.
     *
     * @return true if the command has been executed, false otherwise.
     */
    @Override
    public boolean isExecuted() {
        return isExecuted;
    }

    /**
     * Sets the receiver (robot) for the unsignal command.
     *
     * @param receiver The robot to set as the receiver.
     */
    @Override
    public void setReceiver(IRobot receiver) {
        this.robot=receiver;
    }
    @Override
    public UnsignalCommand clone() {
        try {
            UnsignalCommand clonedCommand = (UnsignalCommand) super.clone();
            return clonedCommand;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
    @Override
    public String toString() {
        return  "Unsignal [" +
                ", Label: " + label +
                "]";
    }
}
