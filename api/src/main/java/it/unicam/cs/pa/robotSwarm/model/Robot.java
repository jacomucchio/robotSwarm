package it.unicam.cs.pa.robotSwarm.model;

import java.util.ArrayList;
import java.util.List;


public class Robot implements IRobot{
    private Point position;
    private ILabel label;
    private Point target;
    private double speed;
    private boolean isShowingCondition;
    private int instructionCounter=0;;
    private List<ICommand> program;
    private double timeForExecution=1;
    public Robot() {
        this.position = new Point(0, 0);
        this.target= new Point(0,0);
        this.speed=0;
        isShowingCondition=false;
        this.program = new ArrayList<>();

    }

    public Robot(Point position) {
        this.position = position;
        this.target= new Point(0,0);
        this.speed=0;
        isShowingCondition=false;
        this.program = new ArrayList<>();
    }
    public Robot(Point position, List<ICommand>program) {
        this.position = position;
        this.target= new Point(0,0);
        this.speed=0;
        isShowingCondition=false;
        this.program=program;
    }

    //costruttore per creare un robot ad una posizione randomica
    public Robot(double x1, double x2,double y1, double y2) {
        double randomX = x1 + Math.random() * (x2 - x1);
        double randomY = y1 + Math.random() * (y2 - y1);
        this.position = new Point(randomX, randomY);
        this.target= new Point(0,0);
        this.speed = 0;
        isShowingCondition = false;
        this.program = new ArrayList<>();
    }

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
    @Override
    public void addCommand(ICommand command){
        this.program.add(command);
    }

    @Override
    public double getExecutionTime() {
        return timeForExecution;
    }


    @Override
    public void move(double x, double y, double speed) {
        this.target=new Point(x,y);
        this.speed=speed;
        DirectionCalculator dir = new DirectionCalculator(this.position,this.target,this.speed);
        this.position= dir.calculateFinalDestination(timeForExecution);
    }
    @Override
    public void continueMove(double seconds) {
        DirectionCalculator dir = new DirectionCalculator(this.position,this.target,this.speed);
        this.position= dir.calculateFinalDestination(seconds);
    }

    @Override
    public void stop() {
        this.speed=0;
        this.target=this.position;
    }

    @Override
    public void signal(ILabel label) {
        this.isShowingCondition=true;
        this.label=label;
    }
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
