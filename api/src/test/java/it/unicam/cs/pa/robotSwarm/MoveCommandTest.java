package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.Point;
import it.unicam.cs.pa.robotSwarm.model.commands.MoveCommand;
import it.unicam.cs.pa.robotSwarm.model.commands.MoveRandomCommand;
import it.unicam.cs.pa.robotSwarm.model.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveCommandTest {
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
    @Test
    public void testExecutionIsDone(){
        Robot r1 = new Robot();
        MoveCommand moveCommand = new MoveCommand(r1,1,0,6);
        moveCommand.execute();
        assertTrue(moveCommand.isExecuted());
    }
    @Test
    public void testMoveCmd(){
        Robot r1 = new Robot(new Point(0,0));
        Robot r2 = new Robot(new Point(10,10));
        MoveCommand mc = new MoveCommand(1,0,5);
        mc.setReceiver(r1);

        MoveCommand mc1 = new MoveCommand(1,0,5);
        mc1.setReceiver(r2);
        r1.addCommand(mc);
        r1.addCommand(mc);
        r2.addCommand(mc1);
        r2.addCommand(mc1);
        System.out.println("dovrei eseguire il comando su r1");
        r1.executeCommand();
        System.out.println("dovrei eseguire il comando su r2");
        r2.executeCommand();
        System.out.println("dovrei eseguire il comando su r1");
        r1.executeCommand();
        System.out.println("dovrei eseguire il comando su r2");
        r2.executeCommand();
    }

    @Test
    public void testClone(){
        Robot r1 = new Robot(new Point(0,0));
        MoveCommand mc = new MoveCommand(1,0,5);
        MoveCommand mc2 = mc.clone();
        mc2.setReceiver(r1);
        r1.addCommand(mc2);
        System.out.println("dovrei eseguire il comando su r1");
        r1.executeCommand();

    }

}
