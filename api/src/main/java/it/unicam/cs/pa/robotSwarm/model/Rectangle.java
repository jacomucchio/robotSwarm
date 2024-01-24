package it.unicam.cs.pa.robotSwarm.model;
/**
 * Implementation of the {@code IArea} interface representing a rectangular area.
 */
public class Rectangle implements IArea{
    /** The label associated with the rectangle. */
    private ILabel label;

    /** The center coordinates of the rectangle. */
    private Point center;

    /** The width of the rectangle. */
    private double width;

    /** The height of the rectangle. */
    private double height;

    /**
     * Constructs a Rectangle with the specified label, center coordinates, width, and height.
     *
     * @param label   The label associated with the rectangle.
     * @param center  The center coordinates of the rectangle.
     * @param width   The width of the rectangle.
     * @param height  The height of the rectangle.
     */
    public Rectangle(ILabel label, Point center, double width, double height) {
        this.label = label;
        this.center = center;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean containsPoint(Point point) {
        double halfWidth = width / 2;
        double halfHeight = height / 2;
        return point.getX() >= center.getX() - halfWidth &&
                point.getX() <= center.getX() + halfWidth &&
                point.getY() >= center.getY() - halfHeight &&
                point.getY() <= center.getY() + halfHeight;
    }

    @Override
    public ILabel getLabel() {
        return label;
    }

    @Override
    public Point getCenter() {
        return center;
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    @Override
    public String toString() {
        return "[Rettangolo con label : "+getLabel()+
                "\n alla posizione: "+getCenter()+
                "\n con altezza: "+getHeight()+
                "\n con larghezza "+getWidth();
    }
}
