package it.unicam.cs.pa.robotSwarm.model;

import java.util.List;
import java.util.Set;

public interface IEnvironment {
    /**
     * Add a robot inside the environment.
     */
    void addRobot(IRobot robot);
    /**
     * Add an area inside the environment.
     */
    void addArea(IArea area);

    void addAreas(List<IArea> areas);

    /**
     * Returns the list of robots in the environment.
     * @return the list of robots.
     */
    List<IRobot> getRobots();

    /**
     * Returns the list of Robots inside the Environment that are displaying the specified condition
     * @param label label of robot
     * @return the list of robots that are displaying the given condition.
     */
    List<IRobot> getRobotsDisplayingCondition(ILabel label);

    /**
     * Returns a list of areas that contain a specific point and have a given label.
     *
     * @param point the point to look for within the areas
     * @param label the label to search for in the areas
     * @return a list of areas that satisfy the search criteria
     */
    List<IArea> getAreasAtPointWithLabel(Point point, ILabel label);

    /**
     * Computes the average position of robots that meet a certain condition within a specified distance from a starting point.
     *
     * @param startingPosition the starting position for distance calculation
     * @param label the label that robots must display to be included in the calculation
     * @param distance the maximum distance within which to include robots in the calculation
     * @return the average position of robots that satisfy the specified criteria
     */
    Point getAveragePositionOfRobotsWithLabel(Point startingPosition, ILabel label, double distance);
}
