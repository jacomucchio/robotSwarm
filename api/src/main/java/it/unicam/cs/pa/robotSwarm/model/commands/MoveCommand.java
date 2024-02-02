package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

/**
 * Represents a command to move a robot to a specified position with a given speed.
 */
public class MoveCommand implements ICommand,Cloneable{
    private IRobot robot;
    private double x, y, speed;

    private boolean isExecuted=false;

    /**
     * Constructs a MoveCommand for a specific robot with target coordinates (x, y) and speed.
     *
     * @param robot The robot to be moved.
     * @param x     The target x-coordinate.
     * @param y     The target y-coordinate.
     * @param speed The speed at which the robot should move.
     */
    public MoveCommand(IRobot robot, double x, double y, double speed) {
        validateParameters(x,y,speed);
        this.robot = robot;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    /**
     * Constructs a MoveCommand with target coordinates (x, y) and speed. The robot must be set separately.
     *
     * @param x     The target x-coordinate.
     * @param y     The target y-coordinate.
     * @param speed The speed at which the robot should move.
     */
    public MoveCommand(double x, double y, double speed) {
        validateParameters(x,y,speed);
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    /**
     * Validates the input parameters (x, y) to ensure they are within the valid range.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @param speed The speed.
     * @throws IllegalArgumentException If the coordinates or speed are out of the valid range.
     */
    private void validateParameters(double x, double y,double speed){
        if(speed<0) throw new IllegalArgumentException("speed must be positive");
        if ((x < -1 || x > 1) || (y < -1 || y > 1)) {
            throw new IllegalArgumentException("x and y must be between -1 and 1");
        }

        if (x == 0 && y == 0) {
            throw new IllegalArgumentException("Only one of x and y can be equal to 0");
        }
    }
    /**
     * Executes the move command, instructing the robot to move to the specified coordinates with the given speed.
     */
    @Override
    public void execute() {
        robot.move(x,y,speed);
        isExecuted=true;
    }

    /**
     * Checks if the move command has been executed.
     *
     * @return True if the command has been executed, false otherwise.
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
    public MoveCommand clone() {
        try {
            MoveCommand clone = (MoveCommand) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    @Override
    public String toString() {
        return "MoveCommand ["
                + ", X: " + x
                + ", Y: " + y
                + ", Speed: " + speed
                + ", Executed: " + isExecuted
                + "]";
    }
}
