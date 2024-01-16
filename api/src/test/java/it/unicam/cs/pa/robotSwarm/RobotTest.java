package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.*;
import it.unicam.cs.pa.robotSwarm.model.commands.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {
    @Test
    public void testCommandExecution() {
        Robot r1 = new Robot();
        Robot r2 = new Robot(new Point(0,10));
        SignalCommand sign = new SignalCommand(r2,new BasicLabel("_A"));
        sign.execute();

        Environment env=new Environment();
        env.addRobot(r1);
        env.addRobot(r2);

        r1.addCommand(new MoveCommand(r1,1,1,4));
        r1.addCommand(new StopCommand(r1));
        r1.addCommand(new FollowCommand(r1,env,new BasicLabel("_A"),20,20));
        r1.addCommand(new MoveRandomCommand(r1,-1,1,-1,1));
        r1.addCommand(new SignalCommand(r1,new BasicLabel("_A")));
        r1.addCommand(new UnsignalCommand(r1));
        r1.executeCommand();
        assertEquals(4,r1.getSpeed());
        r1.executeCommand();
        assertEquals(0,r1.getSpeed());
        r1.executeCommand();
        assertEquals(20,r1.getSpeed());
        r1.executeCommand();
        assertEquals(20,r1.getSpeed());
        r1.executeCommand();
        assertTrue(r1.isShowingCondition());
        assertEquals(new BasicLabel("_A"), r1.getLabel());
        r1.executeCommand();
        assertFalse(r1.isShowingCondition());

    }
}
