package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IEnvironment;
import it.unicam.cs.pa.robotSwarm.model.ILabel;
import it.unicam.cs.pa.robotSwarm.model.IRobot;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a command that iteratively executes a sequence of commands until a specific condition is met.
 */
public class UntilCommand implements IIterativeCommands,Cloneable {
    private IRobot robot;
    private ILabel label;
    private IEnvironment environment;
    private List<ICommand> commands;
    private boolean isExecuted = false;
    private int icounter;

    /**
     * Constructs an UntilCommand associated with a robot, label, environment, and a list of commands.
     *
     * @param robot     The robot involved in the command.
     * @param label     The label used to check the condition.
     * @param environment The environment in which the robot operates.
     * @param commands  The list of commands to execute iteratively.
     */
    public UntilCommand(IRobot robot, ILabel label, IEnvironment environment, List<ICommand> commands) {
        this.robot = robot;
        this.label = label;
        this.environment = environment;
        this.commands = commands;
    }

    /**
     * Constructs an UntilCommand associated with a label and an environment.
     *
     * @param label     The label used to check the condition.
     * @param environment The environment in which the robot operates.
     */
    public UntilCommand(ILabel label, IEnvironment environment) {
        this.label = label;
        this.environment = environment;
        this.commands = new ArrayList<>();
    }

    /**
     * Executes the until command, checking a condition before executing the sequence of commands.
     */
    @Override
    public void execute() {
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

    /**
     * Checks the iteration status and updates the current instruction index for the UntilCommand.
     * If the current command is an iterative command and has not completed its execution,
     * the method resets its status. The method also handles the increment of the instruction index,
     * looping back to the beginning if it reaches the end of the command list.
     */
    private void checkIterationStatus() {
        if (commands.get(icounter) instanceof IIterativeCommands ic) {
            if(!ic.isExecuted()){
                return;
            } else ic.resetStatus();
        }

        if (icounter == commands.size() - 1) {
            icounter = 0;
        } else icounter++;
    }
    /**
     * Checks if the robot is inside an area with the specified label.
     *
     * @return isExecuted=true if the robot is inside the area, false otherwise.
     */
    private boolean checkRobotInsideArea() {
        if(!environment.getAreasAtPointWithLabel(robot.getPosition(), label).isEmpty()){
            isExecuted=true;
        }
        return isExecuted;
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
    @Override
    public UntilCommand clone() {
        try {
            UntilCommand clonedCommand = (UntilCommand) super.clone();
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
        return "Until [" +
                ", Label: " + label +
                "]";
    }
}
