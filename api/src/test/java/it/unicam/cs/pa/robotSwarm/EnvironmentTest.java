package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class EnvironmentTest {
    @Test
    void shouldCreateEnvironmentWithRobots() {
        List<IRobot> robots = new ArrayList<>();
        robots.add(new Robot());
        robots.add(new Robot());

        Environment environment = new Environment(robots);

        assertEquals(robots, environment.getRobots());
    }

    @Test
    void shouldAddRobotToEnvironment() {
        Environment environment = new Environment();
        IRobot robot = new Robot();

        environment.addRobot(robot);

        assertTrue(environment.getRobots().contains(robot));
    }

    @Test
    void shouldAddAreaToEnvironment() {
        Environment environment = new Environment();
        IArea area = new Circle(new Point(0,0), 4,new BasicLabel("_A"));

        environment.addArea(area);

        assertTrue(environment.getAreas().contains(area));
    }

    @Test
    void shouldAddListOfAreasToEnvironment() {
        Environment environment = new Environment();
        List<IArea> areas = new ArrayList<>();
        areas.add(new Circle(new Point(0,0), 4,new BasicLabel("_A")));
        areas.add(new Circle(new Point(0,0), 4,new BasicLabel("_A")));

        environment.addAreas(areas);

        assertTrue(environment.getAreas().containsAll(areas));
    }

    @Test
    void shouldGetRobotsDisplayingCondition() {
        // Arrange
        Environment environment = new Environment();
        ILabel label = new BasicLabel("_ConditionLabel");
        IRobot robot1 = new Robot();
        IRobot robot2 = new Robot();
        robot2.signal(label);
        environment.addRobot(robot1);
        environment.addRobot(robot2);

        List<IRobot> result = environment.getRobotsDisplayingCondition(label);

        assertEquals(List.of(robot2), result);
    }

    @Test
    void shouldGetAreasAtPointWithLabel() {
        // Arrange
        Environment environment = new Environment();
        ILabel label = new BasicLabel("_B");
        IArea area1 = new Circle(new Point(0,0), 4,new BasicLabel("_A"));
        IArea area2 = new Circle(new Point(0,0), 4, label);

        environment.addArea(area1);
        environment.addArea(area2);

        List<IArea> result = environment.getAreasAtPointWithLabel(new Point(0, 0), label);

        assertEquals(List.of(area2), result);
    }

    @Test
    void shouldGetAveragePositionOfRobotsWithLabel() {
        // Arrange
        Environment environment = new Environment();
        ILabel label = new BasicLabel("_RobotLabel");
        IRobot robot1 = new Robot(new Point(1, 1));
        IRobot robot2 = new Robot(new Point(3, 3));
        robot2.signal(label);
        environment.addRobot(robot1);
        environment.addRobot(robot2);

        Point result = environment.getAveragePositionOfRobotsWithLabel(new Point(0, 0), label, 10.0);

        assertEquals(new Point(3.0, 3.0), result);
    }

}
