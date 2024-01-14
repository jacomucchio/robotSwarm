package it.unicam.cs.pa.robotSwarm.model;

public interface IArea {
    boolean containsPoint(Point p);
    ILabel getLabel();
    Point getCenter();
}
