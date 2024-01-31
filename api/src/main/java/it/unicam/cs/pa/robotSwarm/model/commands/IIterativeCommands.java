package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;

/**
 * Represents a command that supports iteration and includes methods for resetting its status and adding subcommands.
 */
public interface IIterativeCommands extends ICommand {
    /**
     * Resets the status of the iterative command. This is used to prepare the command for a new iteration.
     */
    void resetStatus();
    /**
     * Adds a subcommand to the iterative command. Subcommands are executed as part of the overall iteration.
     *
     * @param c The subcommand to be added.
     */
    void addCommand(ICommand c);
}
