package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void execute() {
        System.out.println("sto eseguendo DoForever");
        commands.get(icounter).execute();
        checkIterationStatus();
    }

    public void checkIterationStatus() {
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
            // Clona la lista di comandi
            clonedCommand.commands = new ArrayList<>();
            for (ICommand command : this.commands) {
                clonedCommand.addCommand(command.clone()); // Assicurati che ICommand implementi Cloneable
            }
            // Potrebbe essere necessario clonare anche l'IRobot se implementa Cloneable
            // clonedCommand.robot = this.robot.clone(); // da implementare in IRobot

            return clonedCommand;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }


}
