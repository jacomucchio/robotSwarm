package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

public class MoveCommand implements ICommand,Cloneable{
    private IRobot robot;
    private double x, y, speed;

    private boolean isExecuted=false;

    public MoveCommand(IRobot robot, double x, double y, double speed) {
        validateParameters(x,y);
        this.robot = robot;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    public MoveCommand(double x, double y, double speed) {
        validateParameters(x,y);
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    public void validateParameters(double x, double y){
        if ((x < -1 || x > 1) || (y < -1 || y > 1)) {
            throw new IllegalArgumentException("x and y must be between -1 and 1");
        }

        if (x == 0 && y == 0) {
            throw new IllegalArgumentException("Only one of x and y can be equal to 0");
        }
    }
    @Override
    public void execute() {
        System.out.println("sto eseguendo move");
        robot.move(x,y,speed);
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
    public MoveCommand clone() {
        try {
            MoveCommand clone = (MoveCommand) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
