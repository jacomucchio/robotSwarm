package it.unicam.cs.pa.robotSwarm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * An implementation of the {@code IEnvironment} interface representing the environment
 * in which robots operate. It keeps track of robots and areas within the environment.
 */
public class Environment implements IEnvironment{
    /**
     * List of robots in the environment.
     */
    private List<IRobot> robots;

    /**
     * List of areas in the environment.
     */
    private List<IArea> areas;

    /**
     * Constructs an environment with empty lists of robots and areas.
     */
    public Environment() {
        areas = new ArrayList<>();
        robots = new ArrayList<>();
    }

    /**
     * Constructs an environment with the specified list of robots.
     *
     * @param robots The list of robots to be added to the environment.
     * @throws IllegalArgumentException if the provided list of robots is null.
     */
    public Environment(List<IRobot> robots) {
        if (robots == null) {
            throw new IllegalArgumentException("Robots list cannot be null");
        }
        this.areas = new ArrayList<>();
        this.robots = robots;
    }

    /**
     * Adds a robot to the environment.
     *
     * @param robot The robot to be added.
     */
    @Override
    public void addRobot(IRobot robot) {
        robots.add(robot);
    }

    /**
     * Adds an area to the environment.
     *
     * @param area The area to be added.
     */
    @Override
    public void addArea(IArea area) {
        areas.add(area);
    }

    /**
     * Adds a list of areas to the environment.
     *
     * @param areas The list of areas to be added.
     */
    @Override
    public void addAreas(List<IArea> areas) {
        this.areas.addAll(areas);
    }

    /**
     * Gets a list of all robots in the environment.
     *
     * @return A list of robots in the environment.
     */
    @Override
    public List<IRobot> getRobots() {
        return new ArrayList<>(robots);
    }

    public List<IArea> getAreas() {
        return new ArrayList<>(areas);
    }

    /**
     * Gets a list of robots displaying a specific label.
     *
     * @param label The label to filter robots.
     * @return A list of robots displaying the specified label.
     */
    @Override
    public List<IRobot> getRobotsDisplayingCondition(ILabel label) {
        return robots.stream()
                .filter(robot -> robot.isShowingCondition() && robot.getLabel().equals(label))
                .collect(Collectors.toList());
    }
    /**
     * Gets a list of areas at a specific point with a particular label.
     *
     * @param point The point to check for areas.
     * @param label The label to filter areas.
     * @return A list of areas at the specified point with the given label.
     */
    @Override
    public List<IArea> getAreasAtPointWithLabel(Point point, ILabel label) {
        return areas.stream()
                .filter(area -> area.containsPoint(point) && area.getLabel().equals(label))
                .collect(Collectors.toList());
    }

    /**
     * Gets a list of robots within a certain distance with a specific label.
     *
     * @param referencePoint The reference point for distance calculation.
     * @param distance       The maximum distance for robots to be included.
     * @param label          The label to filter robots.
     * @return A list of robots within the specified distance and having the given label.
     */
    private List<IRobot> getRobotsWithinDistanceWithLabel(Point referencePoint, double distance,ILabel label) {
        return getRobotsDisplayingCondition(label).stream()
                .filter(robot -> calculateDistance(robot.getPosition(), referencePoint) <= distance)
                .collect(Collectors.toList());
    }
    /**
     * Gets the average position of robots with a specific label within a certain distance.
     *
     * @param startingPosition The starting position for distance calculation.
     * @param label            The label to filter robots.
     * @param distance         The maximum distance for robots to be included in the average.
     * @return The average position of robots with the specified label within the given distance.
     */
    @Override
    public Point getAveragePositionOfRobotsWithLabel(Point startingPosition, ILabel label, double distance) {
        List<IRobot> robotsWithLabel = getRobotsWithinDistanceWithLabel(startingPosition,distance,label);
        if (robotsWithLabel.isEmpty()) {
            Random random = new Random();
            double randomX = -distance + random.nextDouble() * 2 * distance;
            double randomY = -distance + random.nextDouble() * 2 * distance;
            return new Point(randomX, randomY);
        }

        double sumX = 0.0;
        double sumY = 0.0;
        for (IRobot robot : robotsWithLabel) {
            Point position = robot.getPosition();
            sumX += position.getX();
            sumY += position.getY();
        }

        double averageX = sumX / robotsWithLabel.size();
        double averageY = sumY / robotsWithLabel.size();

        return new Point(averageX, averageY);
    }
    /**
     * Calculates the Euclidean distance between two points.
     *
     * @param p1 The first point.
     * @param p2 The second point.
     * @return The Euclidean distance between the two points.
     */
    private double calculateDistance(Point p1, Point p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
    
}
