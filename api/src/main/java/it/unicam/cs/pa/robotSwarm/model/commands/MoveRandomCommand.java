package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;
import it.unicam.cs.pa.robotSwarm.model.Point;

public class MoveRandomCommand implements ICommand, Cloneable{
    private IRobot robot;
    private double x1,x2,y1,y2;
    private Point randomPosition;
    private boolean isExecuted=false;
    private double speed;
    public MoveRandomCommand(IRobot robot,double x1, double x2,double y1, double y2, double speed) {
        validateParameters(x1,x2,y1,y2);
        this.robot=robot;
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        this.speed=speed;
    }
    public MoveRandomCommand(double x1, double x2,double y1, double y2,double speed) {
        validateParameters(x1,x2,y1,y2);
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        this.speed=speed;
    }
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

    public void validateParameters(double x1, double x2, double y1,double y2 ){
        if ((x1 < -1 || x1 > 1) || (x2 < -1 || x2 > 1)|| (y1 < -1 || y1 > 1)|| (y2 < -1 || y2 > 1)) {
            throw new IllegalArgumentException("x e y must be within tra -1 e 1");
        }
    }
    public void calculateRandomPosition(){
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
