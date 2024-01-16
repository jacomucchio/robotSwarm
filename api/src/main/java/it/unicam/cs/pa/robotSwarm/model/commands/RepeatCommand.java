package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;
import it.unicam.cs.pa.robotSwarm.model.Robot;

import java.util.List;

public class RepeatCommand implements ICommand {
    private IRobot robot;
    private boolean isExecuted=false;
    private int iterations; //contatore iterazione
    private int icounter; //contatore istruzioni
    private List<ICommand> commands;

    public RepeatCommand(IRobot robot, int i, List<ICommand> commands) {
        this.robot = robot;
        this.iterations=i;
        this.commands=commands;
    }
    @Override
    public void execute() {
        System.out.println("sto eseguendo Repeat");
        commands.get(icounter).execute();
        checkIterationStatus();
    }
    public void checkIterationStatus() {
        if(icounter==commands.size()-1){
            if(iterations>1){
                iterations--;
                icounter=0;
            }
            else isExecuted=true;
        } else icounter++;
    }

    @Override
    public boolean isExecuted() {
        return isExecuted;
    }
}
