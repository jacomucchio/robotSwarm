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


    List<IArea> getAreasAtPointWithLabel(Point point, ILabel label);

    Point getAveragePositionOfRobotsWithLabel(Point startingPosition, ILabel label, double distance);
}
