package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.DirectionCalculator;
import it.unicam.cs.pa.robotSwarm.model.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {
    @Test
    public void testConstructor() {

        DirectionCalculator dir = new DirectionCalculator(new Point(0,0),new Point(0,1),5);
        System.out.println(dir.calculateFinalDestination(1));

    }
}
