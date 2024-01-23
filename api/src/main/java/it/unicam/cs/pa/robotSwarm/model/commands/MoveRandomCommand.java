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
        System.out.println("sto muovendo in modo randomico verso "+randomPosition);
        robot.move(randomPosition.getX(),randomPosition.getY(), speed);
        isExecuted=true;
        System.out.println("sto eseguendo MoveRandom");
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
            throw new IllegalArgumentException("x e y devono essere compresi tra -1 e 1");
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
            // Clona l'IRobot se implementa Cloneable
            // clonedCommand.robot = this.robot.clone(); // da implementare in IRobot

            return clonedCommand;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
}
