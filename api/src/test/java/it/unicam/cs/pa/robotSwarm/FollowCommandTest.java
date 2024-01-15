package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FollowCommandTest {
    @Test
    public void testFollow() {
        Environment env = new Environment();
        Robot r = new Robot();
        Robot r1 = new Robot(new Point(0,100));
        r.addLabel(new BasicLabel("_A"));
        r1.addLabel(new BasicLabel("_A"));
        r.setShowingCondition(true);
        r1.setShowingCondition(true);
        env.addRobot(r);
        env.addRobot(r1);
        FollowCommand f = new FollowCommand(r,env,new BasicLabel("_A"),100,5);
        f.execute();
        assertEquals(new Point(0,50),r.getTarget());
        assertEquals(5,r.getSpeed());
    }
    @Test
    public void testRandomFollow() {
        Environment env = new Environment();
        Robot r = new Robot();
        env.addRobot(r);
        FollowCommand f = new FollowCommand(r,env,new BasicLabel("_A"),50,5);
        f.execute();
        assertTrue(isWithinRange(r.getTarget().getX(), -50, 50));
        assertEquals(5,r.getSpeed());
    }
    private boolean isWithinRange(double value, double min, double max) {
        return value >= min && value <= max;
    }

}
