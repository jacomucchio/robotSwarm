package it.unicam.cs.pa.robotSwarm.model;

import java.util.ArrayList;
import java.util.List;
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
                .filter(robot -> robot.getLabel().equals(label))
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
}
