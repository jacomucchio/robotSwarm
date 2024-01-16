package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.ILabel;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

public class SignalCommand implements ICommand {
    private IRobot robot;
    private ILabel label;
    public SignalCommand(IRobot robot, ILabel label) {
        this.robot=robot;
        this.label=label;
    }

    @Override
    public void execute() {
        robot.signal(label);
    }
}
