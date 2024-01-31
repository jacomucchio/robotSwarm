package it.unicam.cs.pa.robotSwarm.model;

public interface IRobot {
    /**
     * Moves the robot to the specified position (x, y) with the given speed.
     *
     * @param x the x-coordinate of the target position
     * @param y the y-coordinate of the target position
     * @param speed the speed at which the robot should move
     */
    void move(double x, double y, double speed);

    /**
     * Allows the robot to continue its movement for a specified duration in seconds.
     *
     * @param seconds the duration for which the robot should continue moving
     */
    void continueMove(double seconds);
    /**
     * Stops the robot, halting its current movement.
     */
    void stop();

    /**
     * Signals the robot with a specific label, triggering a response based on the label.
     *
     * @param label the label to signal the robot
     */
    void signal(ILabel label);

    /**
     * Remove the specified label from a robot
     *
     * @param label the label to remove the robot
     */
    void unsignal(ILabel label);
    /**
     * Retrieves the label associated with the robot.
     *
     * @return the label of the robot
     */
    ILabel getLabel();
    /**
     * Retrieves the current position of the robot.
     *
     * @return the current position of the robot as a Point object
     */
    Point getPosition();

    /**
     * Checks if the robot is currently displaying a specific condition.
     *
     * @return true if the robot is displaying the condition, false otherwise
     */
    boolean isShowingCondition();

    /**
     * Executes the next command in the robot's command queue.
     */
    void executeCommand();

    /**
     * Adds a command to the robot's command queue.
     *
     * @param command the command to be added to the robot's queue
     */
    void addCommand(ICommand command);

    /**
     * Retrieves the estimated execution time for the next command in the robot's queue.
     *
     * @return the estimated execution time in seconds
     */
    double getExecutionTime();

}
