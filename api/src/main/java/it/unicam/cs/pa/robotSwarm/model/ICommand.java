package it.unicam.cs.pa.robotSwarm.model;

public interface ICommand {
    void execute();
    boolean isExecuted();
    void setReceiver(IRobot receiver);
}
