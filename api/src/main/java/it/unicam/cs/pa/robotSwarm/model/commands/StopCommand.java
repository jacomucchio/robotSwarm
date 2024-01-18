package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

public class StopCommand implements ICommand {
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
    public void setExecuted(boolean executed) {
        this.isExecuted=executed;
    }

    @Override
    public void setReceiver(IRobot receiver) {
        this.robot=receiver;
    }
}
