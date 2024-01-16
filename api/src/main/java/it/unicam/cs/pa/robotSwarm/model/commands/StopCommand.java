package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

public class StopCommand implements ICommand {
    private IRobot robot;
    public StopCommand(IRobot robot) {
        this.robot = robot;
    }
    @Override
    public void execute() {
        robot.stop();
    }
}
