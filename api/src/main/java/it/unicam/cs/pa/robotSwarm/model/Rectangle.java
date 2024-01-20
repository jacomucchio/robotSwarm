package it.unicam.cs.pa.robotSwarm.model;

public class Rectangle implements IArea{
    private ILabel label;
    private Point center;
    private double width;
    private double height;
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
