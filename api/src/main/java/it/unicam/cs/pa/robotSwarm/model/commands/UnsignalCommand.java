package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

public class UnsignalCommand implements ICommand {
    private IRobot robot;
    private boolean isExecuted=false;
    public UnsignalCommand(IRobot robot) {
        this.robot=robot;
    }

    @Override
    public void execute() {
        robot.unsignal();
        isExecuted=true;
        System.out.println("sto eseguendo Unsignal");
    }

    @Override
    public boolean isExecuted() {
        return isExecuted;
    }
}
