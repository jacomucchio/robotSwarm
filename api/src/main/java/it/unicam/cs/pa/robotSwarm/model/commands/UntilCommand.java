package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IEnvironment;
import it.unicam.cs.pa.robotSwarm.model.ILabel;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

import java.util.ArrayList;
import java.util.List;

public class UntilCommand implements IIterativeCommands {
    private IRobot robot;
    private ILabel label;
    private IEnvironment environment;
    private List<ICommand> commands;
    private boolean isExecuted = false;
    private int icounter; //contatore istruzioni

    public UntilCommand(IRobot robot, ILabel label, IEnvironment environment, List<ICommand> commands) {
        this.robot = robot;
        this.label = label;
        this.environment = environment;
        this.commands = commands;
    }
    public UntilCommand(ILabel label, IEnvironment environment, List<ICommand> commands) {
        this.label = label;
        this.environment = environment;
        this.commands = commands;
    }
    public UntilCommand(ILabel label, IEnvironment environment) {
        this.label = label;
        this.environment = environment;
        this.commands = new ArrayList<>();
    }

    @Override
    public void execute() {
        System.out.println("Sto eseguendo Until");
        //in caso cancella l'ho messo perchè ziopera tutti i robot condividono lo stesso comando
        isExecuted=false;
        //
        if(!checkRobotInsideArea()) {
            commands.get(icounter).execute();
            checkIterationStatus();
        }
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

    public void checkIterationStatus() {
        if (commands.get(icounter) instanceof IIterativeCommands ic) {
            if(!ic.isExecuted()){
                return;
            } else ic.resetStatus();
        }

        if (icounter == commands.size() - 1) {
            icounter = 0;
        } else icounter++;
    }
    public boolean checkRobotInsideArea() {
        if(!environment.getAreasAtPointWithLabel(robot.getPosition(), label).isEmpty()){
            isExecuted=true;
            return isExecuted;
        } else return isExecuted;
    }

    @Override
    public void resetStatus() {
        icounter=0;
    }
    @Override
    public void addCommand(ICommand command)
    {
        this.commands.add(command);
    }
}
