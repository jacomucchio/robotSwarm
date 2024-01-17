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

    /**
     * Returns the list of areas in the environment.
     * @return the list of areas
     */
    List<IArea> getAreas();

    /**
     * Returns the list of robots in the environment.
     * @return the list of robots.
     */
    List<IRobot> getRobots();
    /**
     * Returns the list of Robots inside the Environment that contains the specified condition
     * @param label label of robot
     * @return the list of robots with the given condition.
     */
    List<IRobot> getRobotsByLabel(ILabel label);

    /**
     * Returns the list of Robots inside the Environment that are displaying the specified condition
     * @param label label of robot
     * @return the list of robots that are displaying the given condition.
     */
    List<IRobot> getRobotsDisplayingCondition(ILabel label);

    /**
     * Returns the list of Area  inside the Environment
     * @param label label of the area
     * @return the list of area with the given label.
     */
    List<IArea> getAreasByLabel(ILabel label);

    /**
     * Returns a list of areas at the given location.
     *
     * @param point a point.
     * @return a list containing the states of the cells at the given locations.
     */
    List<IArea> getAreasAtPoint(Point point);

    List<IArea> getAreasAtPointWithLabel(Point point, ILabel label);

    Point getAveragePositionOfRobotsWithLabel(Point startingPosition, ILabel label, double distance);
}
