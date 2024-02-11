package it.unicam.cs.pa.robotSwarm.model.commands;
import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.ILabel;
import it.unicam.cs.pa.robotSwarm.model.IRobot;
/**
 * Represents a command to signal a specific label associated with a robot.
 */
public class SignalCommand implements ICommand,Cloneable {
    private IRobot robot;
    private ILabel label;
    private boolean isExecuted=false;
    /**
     * Constructs a SignalCommand associated with a specific robot and label.
     *
     * @param robot The robot to signal.
     * @param label The label to signal.
     * @throws IllegalArgumentException if robot or label is null.
     */
    public SignalCommand(IRobot robot, ILabel label) {
        if (robot == null || label == null) {
            throw new IllegalArgumentException("Robot and label cannot be null");
        }
        this.robot=robot;
        this.label=label;
    }
    /**
     * Constructs a SignalCommand associated with a specific label without linking it to any robot.
     *
     * @param label The label to signal.
     * @throws IllegalArgumentException if label is null.
     */
    public SignalCommand(ILabel label) {
        if (label == null) {
            throw new IllegalArgumentException("Label cannot be null");
        }
        this.label=label;
    }

    /**
     * Executes the signal command, instructing the robot to signal the associated label.
     */
    @Override
    public void execute() {
        robot.signal(label);
        isExecuted=true;
    }

    /**
     * Checks if the signal command has been executed.
     *
     * @return true if the command has been executed, false otherwise.
     */
    @Override
    public boolean isExecuted() {
        return isExecuted;
    }
    @Override
    public void setReceiver(IRobot receiver) {
        this.robot=receiver;
    }

    @Override
    public SignalCommand clone() {
        try {
            SignalCommand clonedCommand = (SignalCommand) super.clone();
            return clonedCommand;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
    @Override
    public String toString() {
        return "Signal [" +
                ", Label: " + label +
                "]";
    }

}
