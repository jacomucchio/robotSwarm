package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

public class StopCommand implements ICommand {
    private IRobot robot;
    private boolean isExecuted=false;
    public StopCommand(IRobot robot) {
        this.robot = robot;
    }
    @Override
    public void execute() {
        robot.stop();
        isExecuted=true;
    }

    @Override
    public boolean isExecuted() {
        return isExecuted;
    }
}
