package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.commands.MoveRandomCommand;
import it.unicam.cs.pa.robotSwarm.model.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveCommandTest {
    @Test
    public void testMoveCommandValidParameters() {
        Robot r = new Robot();
        assertThrows(IllegalArgumentException.class, () -> new MoveRandomCommand(r,0,2,0,0));
        assertThrows(IllegalArgumentException.class, () -> new MoveRandomCommand(r,0,1,2,0));
        assertDoesNotThrow(() -> new MoveRandomCommand(r,0,1,1,-1));
    }
    @Test
    public void testMove() {
        Robot r = new Robot();
        MoveRandomCommand moveRandom = new MoveRandomCommand(r,-1,1,-0.4,0);
        moveRandom.execute();
        assertTrue(isWithinRange(r.getTarget().getX(), -1, 1));
        assertTrue(isWithinRange(r.getTarget().getY(), -0.4, 0));
        assertFalse(isWithinRange(r.getTarget().getY(), 0.1, 1));
    }
    private boolean isWithinRange(double value, double min, double max) {
        return value >= min && value <= max;
    }

}
