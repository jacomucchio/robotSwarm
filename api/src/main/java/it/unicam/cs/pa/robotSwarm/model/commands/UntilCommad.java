package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IEnvironment;
import it.unicam.cs.pa.robotSwarm.model.ILabel;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

import java.util.List;

public class UntilCommad implements ICommand {
    private IRobot robot;
    private ILabel label;
    private IEnvironment environment;
    private List<ICommand> commands;
    private boolean isExecuted = false;
    private int icounter; //contatore istruzioni

    public UntilCommad(IRobot robot, ILabel label, IEnvironment environment, List<ICommand> commands) {
        this.robot = robot;
        this.label = label;
        this.environment = environment;
        this.commands = commands;
    }
    public UntilCommad(ILabel label, IEnvironment environment, List<ICommand> commands) {
        this.robot = robot;
        this.label = label;
        this.environment = environment;
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println("Sto eseguendo Until");
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
    public void setExecuted(boolean executed) {
        this.isExecuted=executed;
    }

    @Override
    public void setReceiver(IRobot receiver) {
        this.robot=receiver;
    }

    public void checkIterationStatus() {
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
}
