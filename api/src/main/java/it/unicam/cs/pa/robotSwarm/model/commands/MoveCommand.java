package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

public class MoveCommand implements ICommand {
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
            throw new IllegalArgumentException("x e y devono essere compresi tra -1 e 1");
        }

        if (x == 0 && y == 0) {
            throw new IllegalArgumentException("Solo uno tra x e y può essere uguale a 0");
        }
    }
    @Override
    public void execute() {
        robot.move(x,y,speed);
        isExecuted=true;
        System.out.println("sto eseguendo Move");
    }

    @Override
    public boolean isExecuted() {
        return isExecuted;
    }
    @Override
    public void setExecuted(boolean executed) {
        this.isExecuted=executed;
    }

    @Override
    public void setReceiver(IRobot receiver) {
        this.robot=receiver;
    }


}
