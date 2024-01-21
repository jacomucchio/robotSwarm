package it.unicam.cs.pa.robotSwarm.model;

import java.util.Set;

public interface IRobot {
    void move(double x, double y, double speed);
    void continueMove(double seconds);
    void stop();
    void signal(ILabel label);
    void unsignal(ILabel label);

    ILabel getLabel();

    void addLabel(ILabel label);
    Point getPosition();
    void setPosition(Point position);

    void setTarget(Point p);
    Point getTarget();
    void setSpeed(double s);
    double getSpeed();
    boolean isShowingCondition();
    void setShowingCondition(boolean condition);
    void executeCommand();
    void addCommand(ICommand command);

    double getExecutionTime();
    void setExecutionTime(double time);

}
