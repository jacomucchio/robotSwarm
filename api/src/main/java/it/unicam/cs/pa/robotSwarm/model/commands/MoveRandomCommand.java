package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;
import it.unicam.cs.pa.robotSwarm.model.Point;

/**
 * Represents a command to move a robot to a random position within specified bounds with a given speed.
 */
public class MoveRandomCommand implements ICommand, Cloneable{
    private IRobot robot;
    private double x1,x2,y1,y2;
    private Point randomPosition;
    private boolean isExecuted=false;
    private double speed;
    /**
     * Constructs a MoveRandomCommand for a specific robot with specified bounds and speed.
     *
     * @param robot The robot to be moved.
     * @param x1    The lower bound of the x-coordinate.
     * @param x2    The upper bound of the x-coordinate.
     * @param y1    The lower bound of the y-coordinate.
     * @param y2    The upper bound of the y-coordinate.
     * @param speed The speed at which the robot should move.
     */
    public MoveRandomCommand(IRobot robot,double x1, double x2,double y1, double y2, double speed) {
        validateParameters(x1,x2,y1,y2);
        this.robot=robot;
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        this.speed=speed;
    }
    /**
     * Constructs a MoveRandomCommand with specified bounds and speed. The robot must be set separately.
     *
     * @param x1    The lower bound of the x-coordinate.
     * @param x2    The upper bound of the x-coordinate.
     * @param y1    The lower bound of the y-coordinate.
     * @param y2    The upper bound of the y-coordinate.
     * @param speed The speed at which the robot should move.
     */
    public MoveRandomCommand(double x1, double x2,double y1, double y2,double speed) {
        validateParameters(x1,x2,y1,y2);
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        this.speed=speed;
    }
    /**
     * Executes the move command, instructing the robot to move to a randomly generated position within the specified range.
     */
    @Override
    public void execute() {
        calculateRandomPosition();
        robot.move(randomPosition.getX(),randomPosition.getY(), speed);
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

    /**
     * Validates the input parameters (x1, x2, y1, y2) to ensure they are within the valid range.
     *
     * @param x1 The lower bound of the x-coordinate range.
     * @param x2 The upper bound of the x-coordinate range.
     * @param y1 The lower bound of the y-coordinate range.
     * @param y2 The upper bound of the y-coordinate range.
     * @throws IllegalArgumentException If the coordinates are out of the valid range.
     */
    public void validateParameters(double x1, double x2, double y1,double y2 ){
        if ((x1 < -1 || x1 > 1) || (x2 < -1 || x2 > 1)|| (y1 < -1 || y1 > 1)|| (y2 < -1 || y2 > 1)) {
            throw new IllegalArgumentException("x e y must be within tra -1 e 1");
        }
    }
    /**
     * Calculates a random position within the specified range.
     */
    private void calculateRandomPosition(){
        double randomX = x1 + Math.random() * (x2 - x1);
        double randomY = y1 + Math.random() * (y2 - y1);
        randomPosition = new Point(randomX, randomY);
    }
    @Override
    public MoveRandomCommand clone() {
        try {
            MoveRandomCommand clonedCommand = (MoveRandomCommand) super.clone();
            return clonedCommand;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return "MoveRandomCommand ["
                + ", X1: " + x1
                + ", X2: " + x2
                + ", Y1: " + y1
                + ", Y2: " + y2
                + ", Random Position: " + randomPosition
                + ", Speed: " + speed
                + ", Executed: " + isExecuted
                + "]";
    }
}
