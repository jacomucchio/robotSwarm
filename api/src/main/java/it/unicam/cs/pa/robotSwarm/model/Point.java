package it.unicam.cs.pa.robotSwarm.model;

import java.util.Objects;
/**
 * Represents a point in a two-dimensional space with x and y coordinates.
 */
public class Point {
    /** The x-coordinate of the point. */
    private final double x;

    /** The y-coordinate of the point. */
    private final double y;

    /**
     * Constructs a new Point with the specified x and y coordinates.
     *
     * @param x The x-coordinate of the point.
     * @param y The y-coordinate of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Calculates the Euclidean distance between this point and another point.
     *
     * @param other The other point.
     * @return The Euclidean distance between this point and the other point.
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    /**
     * Creates a new point by adding specified values to the x and y coordinates of this point.
     *
     * @param dx The value to add to the x-coordinate.
     * @param dy The value to add to the y-coordinate.
     * @return A new point resulting from the addition.
     */
    public Point add(double dx, double dy) {
        return new Point(this.x + dx, this.y + dy);
    }

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
