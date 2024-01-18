package it.unicam.cs.pa.robotSwarm.model.commands;

import it.unicam.cs.pa.robotSwarm.model.ICommand;

public interface IIterativeCommands extends ICommand {
    /*
       Comando per resettare un comando iterativo quando deve essere riusato in un iterazione
     */
    void resetStatus();

    /*
    aggiunge un comando alle istruzioni che deve ripetere
     */
    void addCommand(ICommand c);
}
