package it.unicam.cs.pa.robotSwarm;
import it.unicam.cs.pa.robotSwarm.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {


    @Test
    void shouldCreateRobotWithSpecifiedPosition() {
        Point initialPosition = new Point(2.0, 3.0);
        Robot robot = new Robot(initialPosition,1);
        assertEquals(initialPosition, robot.getPosition());
    }



    @Test
    void shouldMoveRobotToSpecifiedPositionWithGivenSpeed() {
        Robot robot = new Robot();
        double x = 0;
        double y = 1;
        double speed = 5;

        robot.move(x, y, speed);

        assertEquals(new Point(0, 5), robot.getPosition());
    }


    @Test
    void shouldStopRobot() {
        Robot robot = new Robot();
        double x = 5.0;
        double y = 7.0;
        double speed = 2.0;
        robot.move(x, y, speed);
        robot.stop();

        assertEquals(0, robot.getSpeed());

    }

    @Test
    void shouldSignal() {
        Robot robot = new Robot();
        ILabel label = new BasicLabel("_TestLabel");

        robot.signal(label);

        assertTrue(robot.isShowingCondition());
        assertEquals(label, robot.getLabel());
    }

    @Test
    void shouldUnsignal() {
        Robot robot = new Robot();
        ILabel label = new BasicLabel("_TestLabel");
        robot.signal(label);

        robot.unsignal(label);
        assertFalse(robot.isShowingCondition());
    }

}
