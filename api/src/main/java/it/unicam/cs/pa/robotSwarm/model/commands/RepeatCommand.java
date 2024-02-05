package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;
import it.unicam.cs.pa.robotSwarm.model.IRobot;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents a command to repeat a sequence of commands for a specified number of iterations.
 */
public class RepeatCommand implements IIterativeCommands,Cloneable {
    private IRobot robot;
    private boolean isExecuted=false;
    private int iterations;
    private int instructionCounter;
    private List<ICommand> commands;
    private int repetitions;

    /**
     * Constructs a RepeatCommand for a specific robot with a specified number of iterations and a list of commands to repeat.
     *
     * @param robot    The robot on which the commands should be executed.
     * @param iterations The number of iterations to repeat the commands.
     * @param commands  The list of commands to repeat.
     */
    public RepeatCommand(IRobot robot, int iterations, List<ICommand> commands) {
        if(iterations<1) throw new IllegalArgumentException("iterations must be greater than 0");
        if(commands.isEmpty()) throw new IllegalArgumentException("commands list can't be empty");
        this.robot = robot;
        this.iterations=iterations;
        this.commands=commands;
        this.repetitions=iterations;
    }

    /**
     * Constructs a RepeatCommand with a specified number of iterations and a list of commands to repeat.
     * The robot must be set separately.
     *
     * @param iterations The number of iterations to repeat the commands.
     * @param commands   The list of commands to repeat.
     */
    public RepeatCommand(int iterations, List<ICommand> commands) {
        if(iterations<1) throw new IllegalArgumentException("iterations must be greater than 0");
        if(commands.isEmpty()) throw new IllegalArgumentException("commands list can't be empty");
        this.iterations=iterations;
        this.commands=commands;
        this.repetitions=iterations;
    }

    /**
     * Constructs a RepeatCommand for a specific robot with a specified number of iterations.
     *
     * @param iterations The number of iterations to repeat the commands.
     */
    public RepeatCommand(int iterations) {
        if(iterations<1) throw new IllegalArgumentException("iterations must be greater than 0");
        this.iterations=iterations;
        this.commands=new ArrayList<>();
        this.repetitions=iterations;
    }
    @Override
    public void execute() {
        commands.get(instructionCounter).execute();
        checkIterationStatus();
    }


    /**
     * Checks the iteration status and continues the execution of the sequence of commands.
     * This method verifies if the currently executed command is an iterative command.
     * If it is, and the command has not completed the execution of the list of commands it must execute,
     * the counter is not incremented. This ensures the continued execution of the command until
     * it completes its execution.
     */
    public void checkIterationStatus() {
        if (commands.get(instructionCounter) instanceof IIterativeCommands ic) {
            if(!ic.isExecuted()){
                return;
            } else ic.resetStatus();
        }
        if(instructionCounter==commands.size()-1){
            if(iterations>1){
                iterations--;
                instructionCounter=0;
            }
            else isExecuted=true;
        } else instructionCounter++;
    }

    @Override
    public boolean isExecuted() {
        return isExecuted;
    }

    /**
     * Sets the receiver (robot) for each command in the list.
     *
     * @param receiver The robot to which the command should be applied.
     */
    @Override
    public void setReceiver(IRobot receiver) {
        this.robot=receiver;
        for(ICommand cmd: commands)
        {
            cmd.setReceiver(receiver);
        }
    }

    /**
     * Adds a command to the list of commands to repeat.
     *
     * @param command The command to add to the list.
     */
    @Override
    public void addCommand(ICommand command)
    {
        this.commands.add(command);
    }

    /**
     * Resets the status of the repeat command, allowing it to be executed again.
     */
    @Override
    public void resetStatus()
    {
        this.instructionCounter=0;
        this.iterations=repetitions;
        this.isExecuted=false;
    }
    @Override
    public RepeatCommand clone() {
        try {
            RepeatCommand clonedCommand = (RepeatCommand) super.clone();
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
        return "RepeatCommand [" +
                ", Executing "+ commands.get(instructionCounter)+
                ", Executed: " + isExecuted +
                "]";
    }
}
