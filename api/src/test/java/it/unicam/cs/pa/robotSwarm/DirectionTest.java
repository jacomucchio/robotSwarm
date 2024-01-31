package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.utils.DirectionCalculator;
import it.unicam.cs.pa.robotSwarm.model.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DirectionTest {
    @Test
    void shouldCalculateFinalDestinationWhenSpeedIsZero() {
        Point initialPoint = new Point(2.0, 3.0);
        Point targetPoint = new Point(4.0, 6.0);
        double speed = 0.0;
        double timeInSeconds = 10.0;

        DirectionCalculator calculator = new DirectionCalculator(initialPoint, targetPoint, speed);
        Point finalDestination = calculator.calculateFinalDestination(timeInSeconds);

        assertEquals(initialPoint, finalDestination);
    }
    @Test
    void shouldCalculateFinalDestinationWithNonZeroSpeed() {
        Point initialPoint = new Point(0.0, 0.0);
        Point targetPoint = new Point(1.0, 0.0);
        double speed = 10.0;
        double timeInSeconds = 1.0;

        DirectionCalculator calculator = new DirectionCalculator(initialPoint, targetPoint, speed);
        Point finalDestination = calculator.calculateFinalDestination(timeInSeconds);

        assertEquals(new Point(10, 0), finalDestination);
    }


    @Test
    void shouldThrowExceptionForNegativeSpeed() {
        Point initialPoint = new Point(2.0, 3.0);
        Point targetPoint = new Point(4.0, 6.0);
        double negativeSpeed = -2.0;
        assertThrows(IllegalArgumentException.class, () -> new DirectionCalculator(initialPoint, targetPoint, negativeSpeed));
    }

    @Test
    void shouldThrowExceptionForNullInitialPoint() {
        Point nullInitialPoint = null;
        Point targetPoint = new Point(4.0, 6.0);
        double speed = 2.0;

        assertThrows(IllegalArgumentException.class, () -> new DirectionCalculator(nullInitialPoint, targetPoint, speed));
    }

    @Test
    void shouldThrowExceptionForNullTargetPoint() {
        Point initialPoint = new Point(2.0, 3.0);
        Point nullTargetPoint = null;
        double speed = 2.0;
        assertThrows(IllegalArgumentException.class, () -> new DirectionCalculator(initialPoint, nullTargetPoint, speed));
    }
}
