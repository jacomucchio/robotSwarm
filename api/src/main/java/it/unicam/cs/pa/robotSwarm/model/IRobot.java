package it.unicam.cs.pa.robotSwarm.model;

public interface IRobot {
    void move(double x, double y, double speed);
    void continueMove(double seconds);
    void stop();
    void signal(ILabel label);
    void unsignal(ILabel label);
    ILabel getLabel();
    Point getPosition();
    boolean isShowingCondition();
    void executeCommand();
    void addCommand(ICommand command);
    double getExecutionTime();

}
