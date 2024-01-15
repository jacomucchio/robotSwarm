package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SignalTest {
    @Test
    public void testSignal() {
        Robot r1 = new Robot();
        r1.addLabel(new BasicLabel("_A"));
        SignalCommand sc = new SignalCommand(r1);
        sc.execute();
        assertTrue(r1.isShowingCondition());
        UnsignalCommand usc = new UnsignalCommand(r1);
        usc.execute();
        assertFalse(r1.isShowingCondition());
    }
}
