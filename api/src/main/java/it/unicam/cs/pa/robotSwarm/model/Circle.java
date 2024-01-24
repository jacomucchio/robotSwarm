package it.unicam.cs.pa.robotSwarm.model;

/**
 * Implementation of the {@code IArea} interface representing a circular area.
 */
public class Circle implements IArea{
    /** The center coordinates of the circle. */
    private Point center;
    /** The radius of the circle. */
    private double radius;
    /** The label associated with the circle. */
    private ILabel label;

    /**
     * Constructs a Circle with the specified center, radius, and label.
     *
     * @param center The center coordinates of the circle.
     * @param radius The radius of the circle.
     * @param label The label associated with the circle.
     */
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
