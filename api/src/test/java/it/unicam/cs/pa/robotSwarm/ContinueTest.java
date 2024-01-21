package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.IRobot;
import it.unicam.cs.pa.robotSwarm.model.Point;
import it.unicam.cs.pa.robotSwarm.model.Robot;
import it.unicam.cs.pa.robotSwarm.model.commands.ContinueCommand;
import it.unicam.cs.pa.robotSwarm.model.commands.MoveCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContinueTest {

    @Test
    public void testContinue() {
        IRobot r = new Robot();
        r.setExecutionTime(1);
        MoveCommand move = new MoveCommand(0,1,5);
        move.setReceiver(r);
        ContinueCommand continueCommand = new ContinueCommand(6.5);
        continueCommand.setReceiver(r);
        r.addCommand(move);
        r.addCommand(continueCommand);
        r.executeCommand();
        r.setTarget(new Point(100,254));
        r.executeCommand();
        r.executeCommand();
        r.executeCommand();
        r.executeCommand();
        r.executeCommand();
        r.executeCommand();
        r.executeCommand();
        r.executeCommand();
    }
}
