package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.ILabel;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

public class UnsignalCommand implements ICommand,Cloneable {
    private IRobot robot;
    private ILabel label;
    private boolean isExecuted=false;
    public UnsignalCommand(IRobot robot, ILabel label) {
        this.robot=robot;
        this.label=label;
    }
    public UnsignalCommand(ILabel label) {
        this.label=label;
    }

    @Override
    public void execute() {
        robot.unsignal(label);
        isExecuted=true;
        System.out.println("sto eseguendo Unsignal");
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
    public UnsignalCommand clone() {
        try {
            UnsignalCommand clonedCommand = (UnsignalCommand) super.clone();
            // Clona l'IRobot se implementa Cloneable
            // clonedCommand.robot = this.robot.clone(); // da implementare in IRobot

            return clonedCommand;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
}
