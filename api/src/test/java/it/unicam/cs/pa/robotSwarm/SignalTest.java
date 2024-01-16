package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.*;
import it.unicam.cs.pa.robotSwarm.model.commands.SignalCommand;
import it.unicam.cs.pa.robotSwarm.model.commands.UnsignalCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SignalTest {
    @Test
    public void testSignal() {
        Robot r1 = new Robot();
        SignalCommand sc = new SignalCommand(r1,new BasicLabel("_A"));
        sc.execute();
        assertTrue(r1.isShowingCondition());
        assertEquals(new BasicLabel("_A"), r1.getLabel());
        UnsignalCommand usc = new UnsignalCommand(r1);
        usc.execute();
        assertFalse(r1.isShowingCondition());
    }
    @Test
    public void testExecutionIsDone(){
        Robot r1 = new Robot();
        SignalCommand sc = new SignalCommand(r1,new BasicLabel("_A"));
        sc.execute();
        assertTrue(sc.isExecuted());
    }
}
