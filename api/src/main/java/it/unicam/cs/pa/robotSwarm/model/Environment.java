package it.unicam.cs.pa.robotSwarm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Environment implements IEnvironment{
    private List<IRobot> robots;
    private List<IArea> areas;
    public Environment() {
        areas = new ArrayList<>();
        robots = new ArrayList<>();
    }

    @Override
    public void addRobot(IRobot robot) {
        robots.add(robot);
    }

    @Override
    public void addArea(IArea area) {
        areas.add(area);
    }

    @Override
    public List<IArea> getAreas() {
        return new ArrayList<>(areas);
    }

    @Override
    public List<IRobot> getRobots() {
        return new ArrayList<>(robots);
    }

    @Override
    public List<IRobot> getRobotsByLabel(ILabel label) {
        return robots.stream()
                .filter(robot -> robot.getLabel() != null && robot.getLabel().equals(label))
                .collect(Collectors.toList());
    }

    @Override
    public List<IRobot> getRobotsDisplayingCondition(ILabel label) {
        return robots.stream()
                .filter(robot -> robot.isShowingCondition() && robot.getLabel().equals(label))
                .collect(Collectors.toList());
    }

    @Override
    public List<IArea> getAreasByLabel(ILabel l) {
        return areas.stream()
                .filter(area -> area.getLabel().equals(l))
                .collect(Collectors.toList());
    }

    @Override
    public List<IArea> getAreasAtPoint(Point point) {
        return areas.stream()
                .filter(area -> area.containsPoint(point))
                .collect(Collectors.toList());
    }
    @Override
    public List<IArea> getAreasAtPointWithLabel(Point point, ILabel label) {
        return areas.stream()
                .filter(area -> area.containsPoint(point) && area.getLabel().equals(label))
                .collect(Collectors.toList());
    }

    public List<IRobot> getRobotsWithinDistanceWithLabel(Point referencePoint, double distance,ILabel label) {
        return getRobotsDisplayingCondition(label).stream()
                .filter(robot -> calculateDistance(robot.getPosition(), referencePoint) <= distance)
                .collect(Collectors.toList());
    }
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

    private double calculateDistance(Point p1, Point p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
