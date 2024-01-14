package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.BasicLabel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LabelTest {
    @Test
    public void testCreate() {
        assertThrows(IllegalArgumentException.class, () -> new BasicLabel("abc"));
        assertDoesNotThrow(() -> new BasicLabel("_abc"));
    }
}
