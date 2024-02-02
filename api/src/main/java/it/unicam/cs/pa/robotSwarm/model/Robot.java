package it.unicam.cs.pa.robotSwarm.model;

import it.unicam.cs.pa.robotSwarm.utils.DirectionCalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * The Robot class implements the IRobot interface representing a robot
 */
public class Robot implements IRobot{
    private Point position;
    private ILabel label;
    private Point target;
    private double speed;
    private boolean isShowingCondition;
    private int instructionCounter;
    private List<ICommand> program;
    private double timeForExecution=1;

    /**
     * Default constructor for creating a Robot at position (0,0).
     */
    public Robot() {
        this.position = new Point(0, 0);
        this.target= new Point(0,0);
        this.speed=0;
        isShowingCondition=false;
        this.program = new ArrayList<>();
        this.instructionCounter=0;

    }

    /**
     * Constructor for creating a Robot with a specified initial position.
     *
     * @param position The initial position of the Robot.
     */
    public Robot(Point position) {
        this.position = position;
        this.target= new Point(0,0);
        this.speed=0;
        isShowingCondition=false;
        this.program = new ArrayList<>();
        this.instructionCounter=0;
    }

    /**
     * Constructor for creating a Robot with a specified initial position and program.
     *
     * @param position The initial position of the Robot.
     * @param program  The list of commands in the Robot's program.
     */
    public Robot(Point position, List<ICommand>program) {
        this.position = position;
        this.target= new Point(0,0);
        this.speed=0;
        isShowingCondition=false;
        this.program=program;
        this.instructionCounter=0;
    }
    /**
     * Constructor for creating a Robot with a random position within a specified range.
     *
     * @param x1 The minimum x-coordinate for the random position range.
     * @param x2 The maximum x-coordinate for the random position range.
     * @param y1 The minimum y-coordinate for the random position range.
     * @param y2 The maximum y-coordinate for the random position range.
     */
    public Robot(double x1, double x2,double y1, double y2) {
        double randomX = x1 + Math.random() * (x2 - x1);
        double randomY = y1 + Math.random() * (y2 - y1);
        this.position = new Point(randomX, randomY);
        this.target= new Point(0,0);
        this.speed = 0;
        isShowingCondition = false;
        this.program = new ArrayList<>();
    }
    /**
     * The executeCommand method executes the current command in the robot's program.
     * It retrieves the command at the current instruction counter, sets the robot as the receiver,
     * executes the command, and increments the instruction counter if the command is successfully executed.
     */
    public void executeCommand(){
        if(instructionCounter<program.size()) {
            ICommand command = program.get(instructionCounter);
            command.setReceiver(this);
            command.execute();
            if (command.isExecuted()) {
                instructionCounter++;
            }
        }
    }
    /**
     * Adds a new command to the robot's program.
     *
     * @param command The command to be added to the program.
     */
    @Override
    public void addCommand(ICommand command){
        this.program.add(command);
    }

    @Override
    public double getExecutionTime() {
        return timeForExecution;
    }

    /**
     * Moves the robot to a specified position with a given speed.
     * It calculates the final destination based on the time for execution.
     *
     * @param x     The x-coordinate of the target position.
     * @param y     The y-coordinate of the target position.
     * @param speed The speed at which the robot should move.
     */
    @Override
    public void move(double x, double y, double speed) {
        this.target=new Point(x,y);
        this.speed=speed;
        DirectionCalculator dir = new DirectionCalculator(this.position,this.target,this.speed);
        this.position= dir.calculateFinalDestination(timeForExecution);
    }
    /**
     * Continues the robot's movement for a specified duration.
     *
     * @param seconds The duration for which the robot should continue its movement.
     */
    @Override
    public void continueMove(double seconds) {
        DirectionCalculator dir = new DirectionCalculator(this.position,this.target,this.speed);
        this.position= dir.calculateFinalDestination(seconds);
    }
    /**
     * Stops the robot, setting its speed to zero and the target position to its current position.
     */
    @Override
    public void stop() {
        this.speed=0;
        this.target=this.position;
    }
    /**
     * Signals the robot with a specified label, indicating that it is showing a certain condition.
     *
     * @param label The label to be signaled.
     */
    @Override
    public void signal(ILabel label) {
        this.isShowingCondition=true;
        this.label=label;
    }

    /**
     * Unsignals the robot with a specified label, indicating that it is no longer showing a certain condition.
     *
     * @param label The label to be unsignaled.
     */
    @Override
    public void unsignal(ILabel label) {
        if(this.label.equals(label)){
            this.isShowingCondition=false;
        }
    }

    @Override
    public ILabel getLabel() {
        return this.label;
    }

    @Override
    public Point getPosition() {
        return this.position;
    }

    public double getSpeed() {
        return this.speed;
    }
    public Point getTarget() {
        return this.target;
    }
    public List<ICommand> getCommands() {
        return this.program;
    }
    /**
     * Checks if the robot is currently showing a condition.
     *
     * @return True if the robot is showing a condition, false otherwise.
     */
    @Override
    public boolean isShowingCondition() {
        return isShowingCondition;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Robot [");
        builder.append("Position: ").append(position);
        builder.append(", Label: ").append(label);
        builder.append(", Target: ").append(target);
        builder.append(", Speed: ").append(speed);
        builder.append(", Showing Condition: ").append(isShowingCondition);
        builder.append("]");

        if (instructionCounter < program.size()) {
            ICommand currentCommand = program.get(instructionCounter);
            builder.append("\nExecuting Command: ").append(currentCommand);
        } else {
            builder.append("\nCommand execution completed.");
        }

        return builder.toString();
    }
}
