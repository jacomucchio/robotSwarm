package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.*;
import it.unicam.cs.pa.robotSwarm.model.commands.MoveCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveCommandTest {
    @Test
    public void shouldMoveRobotToTheRight() {
        IRobot robot = new Robot();

        MoveCommand moveCommand = new MoveCommand(robot, 1, 0, 5.0);

        moveCommand.execute();
        assertTrue(moveCommand.isExecuted());

        assertEquals(new Point(5,0), robot.getPosition());
    }
    @Test
    public void shouldMoveRobotToTheLeft() {
        IRobot robot = new Robot();

        MoveCommand moveCommand = new MoveCommand(robot, -1, 0, 5.0);

        moveCommand.execute();
        assertTrue(moveCommand.isExecuted());

        assertEquals(new Point(-5,0), robot.getPosition());
    }
    @Test
    public void shouldMoveRobotUp() {
        IRobot robot = new Robot();

        MoveCommand moveCommand = new MoveCommand(robot, 0, 1, 5.0);

        moveCommand.execute();
        assertTrue(moveCommand.isExecuted());

        assertEquals(new Point(0,5), robot.getPosition());
    }
    @Test
    public void shouldMoveRobotDown() {
        IRobot robot = new Robot();

        MoveCommand moveCommand = new MoveCommand(robot, 0, -1, 5.0);

        moveCommand.execute();
        assertTrue(moveCommand.isExecuted());

        assertEquals(new Point(0,-5), robot.getPosition());
    }
    @Test
    public void shouldThrowExceptionForInvalidCoordinates() {
        assertThrows(IllegalArgumentException.class, () -> new MoveCommand(new Robot(), 1.5, 0.8, 2.0));
        assertThrows(IllegalArgumentException.class, () -> new MoveCommand(new Robot(), -0.5, 1.8, 2.0));
        assertThrows(IllegalArgumentException.class, () -> new MoveCommand(new Robot(), 0.5, 0.8, -2.0));
    }

}
