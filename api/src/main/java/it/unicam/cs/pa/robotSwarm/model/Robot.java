package it.unicam.cs.pa.robotSwarm.model;


import javax.management.DescriptorRead;
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
        } else System.out.println("esecuzione dei comandi terminata");
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
    public void setExecutionTime(double time) {
        this.timeForExecution=time;
    }


    @Override
    public void move(double x, double y, double speed) {
        System.out.println("il target è "+x+" "+y);
        this.target=new Point(x,y);
        this.speed=speed;
        DirectionCalculator dir = new DirectionCalculator(this.position,this.target,this.speed);
        this.position= dir.calculateFinalDestination(timeForExecution);
        System.out.println("la mia posizione dopo lo spostamento è "+this.getPosition());
    }
    @Override
    public void continueMove(double seconds) {
        DirectionCalculator dir = new DirectionCalculator(this.position,this.target,this.speed);
        this.position= dir.calculateFinalDestination(seconds);
        System.out.println("la mia posizione dopo continue è: "+this.getPosition());
    }

    @Override
    public void stop() {
        this.speed=0;
        this.target=this.position;
        System.out.println("la mia posizione dopo stop è: "+this.getPosition());
    }

    @Override
    public void signal(ILabel label) {
        this.isShowingCondition=true;
        this.label=label;
        System.out.println("l'etichetta che sto segnalando è "+this.getLabel());
    }
    @Override
    public void unsignal(ILabel label) {
        if(this.label.equals(label)){
            this.isShowingCondition=false;
            System.out.println("ho smesso di segnalare la condizione");
        }
    }

    @Override
    public ILabel getLabel() {
        return this.label;
    }

    @Override
    public void addLabel(ILabel label) {
        this.label=label;
    }

    @Override
    public Point getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Point position) {
        this.position=position;
    }

    @Override
    public void setTarget(Point p) {
        this.target=p;
    }

    @Override
    public Point getTarget() {
        return this.target;
    }

    @Override
    public void setSpeed(double s) {
        this.speed=s;
    }

    @Override
    public double getSpeed() {
        return this.speed;
    }

    @Override
    public boolean isShowingCondition() {
        return isShowingCondition;
    }

    @Override
    public void setShowingCondition(boolean condition) {
        this.isShowingCondition=condition;
    }

    @Override
    public String toString() {
        return "[Robot alla posizione: "+position+
                "\n con target: "+target+
                "\n con velocita: "+speed+
                "\n con label: "+label+"]\n";
    }
}
