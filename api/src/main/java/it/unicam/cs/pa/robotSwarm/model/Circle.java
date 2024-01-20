package it.unicam.cs.pa.robotSwarm.model;

public class Circle implements IArea{
    private Point center;
    private double radius;
    private ILabel label;
    public Circle(Point center, double radius, ILabel label){
        this.center=center;
        this.radius=radius;
        this.label=label;
    }

    @Override
    public boolean containsPoint(Point p){
        return center.distance(p) <= radius;
    }
    @Override
    public ILabel getLabel() {
        return label;
    }
    @Override
    public Point getCenter() {
        return center;
    }
    public double getRadius() {
        return radius;
    }
    @Override
    public String toString() {
        return "[Cerchio con label : "+getLabel()+
                "\n alla posizione: "+getCenter()+
                "\n con raggio: "+getRadius()+ "]\n";
    }
}
