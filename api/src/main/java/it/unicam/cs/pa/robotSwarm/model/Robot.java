package it.unicam.cs.pa.robotSwarm.model;



public class Robot implements IRobot{
    private Point position;
    private ILabel label;
    private Point target;
    private double speed;

    public Robot() {
        this.position = new Point(0, 0);
        this.target= new Point(0,0);
        this.speed=0;
    }
    public Robot(Point position) {
        this.position = position;
        this.target= new Point(0,0);
        this.speed=0;
    }

    @Override
    public void move(double x, double y, double speed) {
        System.out.println("Mi sto muovendo verso:"+ x+","+ y+" alla velocità "+speed);
        this.target=new Point(x,y);
        this.speed=speed;
    }

    @Override
    public void stop() {
        this.speed=0;
        this.target=this.position;
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
}
