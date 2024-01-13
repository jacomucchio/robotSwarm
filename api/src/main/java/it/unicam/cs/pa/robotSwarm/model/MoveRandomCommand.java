package it.unicam.cs.pa.robotSwarm.model;

public class MoveRandomCommand implements ICommand{
    private IRobot robot;
    private double x1,x2,y1,y2;
    private Point randomPosition;
    public MoveRandomCommand(IRobot robot,double x1, double x2,double y1, double y2) {
        validateParameters(x1,x2,y1,y2);
        this.robot=robot;
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        calculateRandomPosition();
    }
    @Override
    public void execute() {
        robot.move(randomPosition.getX(),randomPosition.getY(), robot.getSpeed());
    }
    public void validateParameters(double x1, double x2, double y1,double y2 ){
        if ((x1 < -1 || x1 > 1) || (x2 < -1 || x2 > 1)|| (y1 < -1 || y1 > 1)|| (y2 < -1 || y2 > 1)) {
            throw new IllegalArgumentException("x e y devono essere compresi tra -1 e 1");
        }
    }
    public void calculateRandomPosition(){
        double randomX = x1 + Math.random() * (x2 - x1);
        double randomY = y1 + Math.random() * (y2 - y1);
        randomPosition = new Point(randomX, randomY);
    }
}