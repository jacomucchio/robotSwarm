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

}
