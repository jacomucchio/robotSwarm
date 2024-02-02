package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.*;
import it.unicam.cs.pa.robotSwarm.model.commands.SignalCommand;
import it.unicam.cs.pa.robotSwarm.model.commands.UnsignalCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SignalTest {
    @Test
    public void shouldSignal() {
        Robot r1 = new Robot();
        SignalCommand sc = new SignalCommand(r1,new BasicLabel("_A"));
        sc.execute();
        assertTrue(r1.isShowingCondition());
        assertEquals(new BasicLabel("_A"), r1.getLabel());
        UnsignalCommand usc = new UnsignalCommand(r1, new BasicLabel("_A"));
        usc.execute();
        assertFalse(r1.isShowingCondition());
    }
    @Test
    public void shouldExecute(){
        Robot r1 = new Robot();
        SignalCommand sc = new SignalCommand(r1,new BasicLabel("_A"));
        sc.execute();
        assertTrue(sc.isExecuted());
    }
    @Test
    public void shouldCloneTest(){
        Robot r1 = new Robot();
        SignalCommand sc = new SignalCommand(r1,new BasicLabel("_A"));
        SignalCommand scCloned = sc.clone();
        scCloned.setReceiver(r1);
        scCloned.execute();
        assertTrue(scCloned.isExecuted());
    }
}
