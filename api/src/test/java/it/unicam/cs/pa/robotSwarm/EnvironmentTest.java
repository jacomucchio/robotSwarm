package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class EnvironmentTest {
    private Environment environment;
    private IRobot robot1, robot2;
    private IArea area1, area2;

    @BeforeEach
    public void setUp() {
        environment = new Environment();
        robot1 = new Robot(new Point(0,0));
        robot2 = new Robot(new Point(0,100));
        area1 = new Circle(new Point(0,0),10,new BasicLabel("_A"));
        area2 = new Rectangle(new BasicLabel("_A"),new Point(0,100),10, 20);
        environment.addArea(area1);
        environment.addArea(area2);
        environment.addRobot(robot1);
        environment.addRobot(robot2);

    }

    @Test
    public void testAddAndGetRobots() {
        assertEquals(List.of(robot1, robot2), environment.getRobots());
    }

    @Test
    public void testAddAndGetAreas() {
        assertEquals(List.of(area1, area2), environment.getAreas());
    }

    @Test
    public void testGetRobotsByLabel() {
        robot1.addLabel(new BasicLabel("_A"));
        List<IRobot> expectedRobots = new ArrayList<>();
        expectedRobots.add(robot1);
        assertEquals(expectedRobots, environment.getRobotsByLabel(new BasicLabel("_A")));
        expectedRobots.add(robot2);
        assertNotEquals(expectedRobots, environment.getRobotsByLabel(new BasicLabel("_A")));
        robot2.addLabel(new BasicLabel("_A"));
        assertEquals(expectedRobots, environment.getRobotsByLabel(new BasicLabel("_A")));
    }
    @Test
    public void testGetRobotsDisplayingCondition(){
        robot1.addLabel(new BasicLabel("_A"));
        robot2.addLabel(new BasicLabel("_A"));
        robot1.setShowingCondition(true);
        List<IRobot> expectedRobots = new ArrayList<>();
        expectedRobots.add(robot1);
        assertEquals(expectedRobots,environment.getRobotsDisplayingCondition(new BasicLabel("_A")));
    }
    @Test
    public void testGetAreasAtPoint(){
        IArea area3 = new Circle(new Point(0,0),10,new BasicLabel("_I"));
        environment.addArea(area3);
        List<IArea> expectedArea = new ArrayList<>();
        expectedArea.add(area1);
        expectedArea.add(area3);
        assertEquals(expectedArea,environment.getAreasAtPoint(new Point(0,0)));
    }

    @Test
    public void testGetRobotsWithinDistanceWithLabel(){
        Robot robot3 =new Robot(new Point(5,0));
        Robot robot4 =new Robot(new Point(0,5));
        Robot robot5 =new Robot(new Point(0,-5));

        robot1.setShowingCondition(true);
        robot1.addLabel(new BasicLabel("_A"));
        robot3.addLabel(new BasicLabel("_A"));
        robot3.setShowingCondition(true);
        robot4.setShowingCondition(true);
        robot4.addLabel(new BasicLabel("_B"));
        robot5.setShowingCondition(true);
        robot5.addLabel(new BasicLabel("_A"));

        environment.addRobot(robot3);
        environment.addRobot(robot4);
        environment.addRobot(robot5);
        List<IRobot> expectedRobots = new ArrayList<>();
        expectedRobots.add(robot1);
        expectedRobots.add(robot3);
        expectedRobots.add(robot5);
        assertEquals(expectedRobots,
                environment.getRobotsWithinDistanceWithLabel(robot1.getPosition(),5,new BasicLabel("_A")));

    }
    @Test
    public void testGetAveragePositionOfRobotsWithLabel(){
        Robot robot3 =new Robot(new Point(5,0));
        Robot robot4 =new Robot(new Point(-5,0));
        robot1.setShowingCondition(true);
        robot1.addLabel(new BasicLabel("_A"));
        robot3.addLabel(new BasicLabel("_A"));
        robot3.setShowingCondition(true);
        robot4.setShowingCondition(true);
        robot4.addLabel(new BasicLabel("_A"));
        environment.addRobot(robot3);
        environment.addRobot(robot4);
        assertEquals(new Point(0,0),
                environment.getAveragePositionOfRobotsWithLabel(robot1.getPosition(),new BasicLabel("_A"),5));
    }
    @Test
    public void testRobotShouldBeInsideArea(){
        Environment e = new Environment();
        Robot r1 = new Robot();
        Circle c = new Circle(new Point(0,0),10,new BasicLabel("_A"));
        Circle c1 = new Circle(new Point(10,10),1,new BasicLabel("_A"));
        Circle c2 = new Circle(new Point(0,0),10,new BasicLabel("_A1"));
        Rectangle r = new Rectangle(new BasicLabel("_A"),new Point(0,0),10,20);
        e.addRobot(r1);
        e.addArea(c);
        assertFalse(e.getAreasAtPointWithLabel(r1.getPosition(),new BasicLabel("_A")).isEmpty());
        e.addArea(r);
        e.addArea(c1);
        e.addArea(c2);
        assertEquals(2, e.getAreasAtPointWithLabel(r1.getPosition(),new BasicLabel("_A")).size());

    }
}
