package it.unicam.cs.pa.robotSwarm;
import it.unicam.cs.pa.robotSwarm.model.IRobot;
import it.unicam.cs.pa.robotSwarm.model.Robot;
import it.unicam.cs.pa.robotSwarm.model.commands.MoveCommand;
import it.unicam.cs.pa.robotSwarm.model.commands.MoveRandomCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MoveRandomTest {
    @Test
    public void shouldMoveRobotToRandomPosition() {
        Robot robot = new Robot();
        MoveRandomCommand moveRandomCommand = new MoveRandomCommand(robot, -0.5, 0.5, -0.8, 0.8, 2.0);

        moveRandomCommand.execute();
        assertTrue(moveRandomCommand.isExecuted());

        assertTrue(robot.getTarget().getX()>= -0.5 && robot.getTarget().getX() <= 0.5);
        assertTrue(robot.getTarget().getY() >= -0.8 && robot.getTarget().getY() <= 0.8);
    }
    @Test
    public void shouldThrowExceptionForInvalidCoordinates() {
        assertThrows(IllegalArgumentException.class, () -> new MoveRandomCommand(new Robot(), 1.5, 0.5, -0.8, 0.8, 2.0));
        assertThrows(IllegalArgumentException.class, () -> new MoveRandomCommand(new Robot(), -0.5, 0.5, 1.8, 0.8, 2.0));
        assertThrows(IllegalArgumentException.class, () -> new MoveRandomCommand(new Robot(), -0.5, 0.5, -0.8, 0.8, -2.0));
    }
}
