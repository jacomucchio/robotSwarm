package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a command that executes a list of commands in a loop indefinitely.
 */
public class DoForeverCommand implements IIterativeCommands, Cloneable {
    private IRobot robot;
    private List<ICommand> commands;
    private int icounter;
    private boolean isExecuted=false;

    public DoForeverCommand(IRobot robot, List<ICommand> commands) {
        this.robot = robot;
        this.commands=commands;
    }
    public DoForeverCommand(List<ICommand> commands) {
        this.commands=commands;
    }
    public DoForeverCommand() {
        this.commands=new ArrayList<>();
    }

    /**
     * Executes the command at icounter position
     */
    @Override
    public void execute() {
        commands.get(icounter).execute();
        checkIterationStatus();
    }
    /**
     * Checks the status of the current iteration and resets it if needed.
     */
    private void checkIterationStatus() {
        if (commands.get(icounter) instanceof IIterativeCommands ic) {
            if(!ic.isExecuted()){
                return;
            } else ic.resetStatus();
        }

        if(icounter==commands.size()-1){
            icounter=0;
        } else icounter++;
    }

    @Override
    public boolean isExecuted() {
        return isExecuted;
    }

    @Override
    public void setReceiver(IRobot receiver) {
        if(receiver==null) throw new NullPointerException("Receiver cannot be null");
        this.robot=receiver;
        for(ICommand cmd: commands)
        {
            cmd.setReceiver(receiver);
        }
    }

    @Override
    public void resetStatus() {

    }

    @Override
    public void addCommand(ICommand c) {
        commands.add(c);
    }

    @Override
    public DoForeverCommand clone() {
        try {
            DoForeverCommand clonedCommand = (DoForeverCommand) super.clone();
            clonedCommand.commands = new ArrayList<>();
            for (ICommand command : this.commands) {
                clonedCommand.addCommand(command.clone());
            }
            return clonedCommand;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return "DoForeverCommand ["
                + ", Commands: " + commands
                + ", Iteration Counter: " + icounter
                + ", Executed: " + isExecuted
                + "]";
    }
}
