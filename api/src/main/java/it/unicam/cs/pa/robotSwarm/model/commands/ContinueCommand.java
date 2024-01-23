package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

public class ContinueCommand implements ICommand,Cloneable {
    //TODO implementare
    private IRobot robot;
    private double seconds;
    private boolean isExecuted=false;

    public ContinueCommand(IRobot robot,double seconds) {
        if(seconds<0) throw new IllegalArgumentException("seconds must be positive");
        this.robot = robot;
        this.seconds=seconds;
    }
    public ContinueCommand(double seconds) {
        if(seconds<0) throw new IllegalArgumentException("seconds must be positive");
        this.seconds=seconds;
    }

    @Override
    public void execute() {
        System.out.println("sto eseguendo continue" +seconds);
        if(seconds<robot.getExecutionTime())
        {
            System.out.println("fine");
            robot.continueMove(seconds);
            isExecuted=true;
        } else {
            robot.continueMove(robot.getExecutionTime());
            seconds -= robot.getExecutionTime();
        }
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
    public ContinueCommand clone() {
        try {
            return (ContinueCommand) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

}
