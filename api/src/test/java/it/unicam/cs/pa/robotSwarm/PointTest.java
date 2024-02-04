package it.unicam.cs.pa.robotSwarm;

import org.junit.jupiter.api.Test;
import it.unicam.cs.pa.robotSwarm.model.Point;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    @Test
    void shouldCreatePointWithSpecifiedCoordinates() {
        double x = 3.0;
        double y = 4.0;

        Point point = new Point(x, y);

        assertEquals(x, point.getX());
        assertEquals(y, point.getY());
    }


    @Test
    void shouldCalculateDistanceBetweenTwoPoints() {
        Point point1 = new Point(1.0, 1.0);
        Point point2 = new Point(4.0, 5.0);

        double distance = point1.distance(point2);

        assertEquals(5.0, distance);
    }

    @Test
    void shouldCreateNewPointByAddingValues() {
        Point point = new Point(2.0, 3.0);
        double dx = 1.0;
        double dy = -2.0;

        Point newPoint = point.add(dx, dy);

        assertEquals(3.0, newPoint.getX());
        assertEquals(1.0, newPoint.getY());
    }

    @Test
    void shouldEqualPointsWithSameCoordinates() {
        Point point1 = new Point(3.0, 4.0);
        Point point2 = new Point(3.0, 4.0);
        assertEquals(point1, point2);
    }
    @Test
    void shouldNotEqualPointsWithDifferentCoordinates() {
        Point point1 = new Point(1.0, 2.0);
        Point point2 = new Point(3.0, 4.0);

        assertNotEquals(point1, point2);
    }


}
