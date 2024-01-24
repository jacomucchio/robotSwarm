package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

public class StopCommand implements ICommand, Cloneable {
    private IRobot robot;
    private boolean isExecuted=false;
    public StopCommand(IRobot robot) {
        this.robot = robot;
    }
    public StopCommand() {
    }
    @Override
    public void execute() {
        robot.stop();
        isExecuted=true;
        System.out.println("sto eseguendo Stop");
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
    public StopCommand clone() {
        try {
            StopCommand clonedCommand = (StopCommand) super.clone();
            return clonedCommand;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

}
