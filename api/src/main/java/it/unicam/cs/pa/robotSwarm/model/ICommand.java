package it.unicam.cs.pa.robotSwarm.model;
/**
 * Interface representing a command in a command pattern structure.
 * This interface defines the basic structure of a command that can be executed on a receiver,
 * an instance of {@code IRobot}.
 */
public interface ICommand {
    /**
     * Executes the command. The specific behavior of this method depends on the implementation
     * and the nature of the command. This method is used to change the state of the receiver.
     */
    void execute();
    /**
     * Checks if the command has been executed.
     *
     * @return {@code true} if the command has already been executed, otherwise {@code false}.
     */
    boolean isExecuted();
    /**
     * Sets the receiver of the command. The receiver is the object on which the command
     * will perform its action.
     *
     * @param receiver The {@code IRobot} that will receive and execute the command.
     */
    void setReceiver(IRobot receiver);
    /**
     * Creates and returns a new instance that is a copy of this command.
     *
     * @return A new instance that is a copy of this command.
     */
    ICommand clone();
}
