package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.ILabel;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

public class SignalCommand implements ICommand,Cloneable {
    private IRobot robot;
    private ILabel label;
    private boolean isExecuted=false;
    public SignalCommand(IRobot robot, ILabel label) {
        this.robot=robot;
        this.label=label;
    }
    public SignalCommand(ILabel label) {
        this.label=label;
    }

    @Override
    public void execute() {
        robot.signal(label);
        isExecuted=true;
        System.out.println("sto eseguendo Signal");
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
    public SignalCommand clone() {
        try {
            SignalCommand clonedCommand = (SignalCommand) super.clone();
            return clonedCommand;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
}
