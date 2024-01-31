package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.IRobot;
import it.unicam.cs.pa.robotSwarm.model.Point;
import it.unicam.cs.pa.robotSwarm.model.Robot;
import it.unicam.cs.pa.robotSwarm.model.commands.ContinueCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ContinueTest {

    @Test
    void shouldNotExecuteCommand() {
        IRobot robot = new Robot();
        ContinueCommand continueCommand = new ContinueCommand(robot, 3.0);

        continueCommand.execute();

        assertFalse(continueCommand.isExecuted());
        assertEquals(new Point(0.0, 0.0), robot.getPosition());
    }

    @Test
    void shouldMarkAsExecuted() {
        IRobot robot = new Robot();
        ContinueCommand continueCommand = new ContinueCommand(robot, 1.0);
        continueCommand.execute();
        assertFalse(continueCommand.isExecuted());
        continueCommand.execute();
        assertTrue(continueCommand.isExecuted());
        assertEquals(new Point(0.0, 0.0), robot.getPosition());
    }



    @Test
    void shouldNotExecuteCommandWhenSecondsAreZero() {
        IRobot robot = new Robot();
        ContinueCommand continueCommand = new ContinueCommand(robot, 0.0);

        continueCommand.execute();
        assertTrue(continueCommand.isExecuted());
        assertEquals(new Point(0.0, 0.0), robot.getPosition());
    }

    @Test
    void shouldCloneContinueCommand() {
        IRobot robot = new Robot();
        ContinueCommand originalCommand = new ContinueCommand(robot, 3.0);

        ContinueCommand clonedCommand = originalCommand.clone();
        assertNotSame(originalCommand, clonedCommand);
        assertEquals(originalCommand.toString(), clonedCommand.toString());
    }

    @Test
    void shouldThrowExceptionForNegativeSecondsInConstructor() {
        IRobot robot = new Robot();
        assertThrows(IllegalArgumentException.class, () -> new ContinueCommand(robot, -2.0));
    }


}
