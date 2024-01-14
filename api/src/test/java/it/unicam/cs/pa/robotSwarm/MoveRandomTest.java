package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.MoveCommand;
import it.unicam.cs.pa.robotSwarm.model.Point;
import it.unicam.cs.pa.robotSwarm.model.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveRandomTest {
    @Test
    public void testMoveCommandValidParameters() {
        Robot r = new Robot();
        assertThrows(IllegalArgumentException.class, () -> new MoveCommand(r,0,0,4));
        assertThrows(IllegalArgumentException.class, () -> new MoveCommand(r,2,0,4));
        assertThrows(IllegalArgumentException.class, () -> new MoveCommand(r,0,2,4));
        assertDoesNotThrow(() -> new MoveCommand(r,0,1,4));
    }
    @Test
    public void testMove() {
        Robot r = new Robot();
        MoveCommand moveCommand = new MoveCommand(r,1,0,6);
        moveCommand.execute();
        assertEquals(6.0,r.getSpeed());
        assertEquals(new Point(1,0),r.getTarget());
    }
}
