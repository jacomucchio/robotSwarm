package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

import java.util.List;

public class DoForeverCommand implements ICommand {
    private IRobot robot;
    private List<ICommand> commands;
    private int icounter;

    public DoForeverCommand(IRobot robot, List<ICommand> commands) {
        this.robot = robot;
        this.commands=commands;
    }

    @Override
    public void execute() {
        System.out.println("sto eseguendo DoForever");
        commands.get(icounter).execute();
        checkIterationStatus();
    }

    public void checkIterationStatus() {
        if(icounter==commands.size()-1){
            icounter=0;
        } else icounter++;
    }

    @Override
    public boolean isExecuted() {
        return false;
    }
}