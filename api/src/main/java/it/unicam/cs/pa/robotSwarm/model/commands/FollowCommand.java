package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.*;
/**
 * Represents a command to make the robot follow a target with a specified label.
 */
public class FollowCommand implements ICommand, Cloneable{
    private IRobot robot;
    private IEnvironment environment;
    double distance,speed;
    Point target;
    ILabel label;
    private boolean isExecuted=false;

    /**
     * Constructs a FollowCommand associated with a robot, environment, label, distance, and speed.
     *
     * @param r         The robot involved in the command.
     * @param e         The environment in which the robot operates.
     * @param label     The label used to check the condition.
     * @param dist      The distance within which to find robots with the specified label.
     * @param speed     The speed at which the robot should move.
     */
    public FollowCommand(IRobot r, IEnvironment e, ILabel label, double dist, double speed) {
        this.robot=r;
        this.environment=e;
        this.distance=dist;
        this.speed=speed;
        this.label=label;
    }
    /**
     * Constructs a FollowCommand associated with an environment, label, distance, and speed.
     *
     * @param e         The environment in which the robot operates.
     * @param label     The label used to check the condition.
     * @param dist      The distance within which to find robots with the specified label.
     * @param speed     The speed at which the robot should move.
     */
    public FollowCommand(IEnvironment e, ILabel label, double dist, double speed) {
        this.environment=e;
        this.distance=dist;
        this.speed=speed;
        this.label=label;
    }
    /**
     * Executes the FollowCommand, making the robot follow a target with a specified label.
     */
    @Override
    public void execute() {
        target=environment.getAveragePositionOfRobotsWithLabel(robot.getPosition(),label,distance);
        robot.move(target.getX(), target.getY(), speed);
        isExecuted=true;
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
    public FollowCommand clone() {
        try {
            FollowCommand clonedCommand = (FollowCommand) super.clone();
            clonedCommand.environment = this.environment;
            return clonedCommand;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
    @Override
    public String toString() {
        return "FollowCommand ["
                + ", Distance: " + distance
                + ", Speed: " + speed
                + ", Target: " + target
                + ", Label: " + label
                + ", Executed: " + isExecuted
                + "]";
    }
}
