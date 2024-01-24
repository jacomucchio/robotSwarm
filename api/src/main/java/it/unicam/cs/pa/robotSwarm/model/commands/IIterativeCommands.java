package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;

public interface IIterativeCommands extends ICommand {
    void resetStatus();

    void addCommand(ICommand c);
}
