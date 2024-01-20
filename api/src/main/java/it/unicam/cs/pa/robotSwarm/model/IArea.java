package it.unicam.cs.pa.robotSwarm.model;
/**
 * Interface representing a geometric area.
 * This interface defines methods to interact with a geometric shape,
 * such as checking if a point is contained within the area,
 * retrieving the label of the area, and getting the central point of the area.
 */
public interface IArea {
    /**
     * Checks if the given point is contained within this area.
     *
     * @param p The {@code Point} to check.
     * @return {@code true} if the point is within the area, otherwise {@code false}.
     */
    boolean containsPoint(Point p);
    /**
     * Gets the label associated with this area.
     *
     * @return The {@code ILabel} representing the label of this area.
     */
    ILabel getLabel();
    /**
     * Gets the central point of this area.
     *
     * @return The {@code Point} representing the central point of the area.
     */
    Point getCenter();
}
