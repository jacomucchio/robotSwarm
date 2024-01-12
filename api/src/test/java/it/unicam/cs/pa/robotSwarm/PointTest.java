package it.unicam.cs.pa.robotSwarm;

import org.junit.jupiter.api.Test;
import it.unicam.cs.pa.robotSwarm.model.Point;

import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    @Test
    public void testCreateAndGet() {
        Point p = new Point(3.0, 4.0);
        assertEquals(3.0, p.getX(), 0.001);
        assertEquals(4.0, p.getY(), 0.001);
    }

    // Test per i metodi setX e setY
    @Test
    public void testSet() {
        Point p = new Point(3.0, 4.0);
        p.setX(5.0);
        p.setY(6.0);
        assertEquals(5.0, p.getX(), 0.001);
        assertEquals(6.0, p.getY(), 0.001);
    }

    // Test per il metodo distance
    @Test
    public void testDistance() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        assertEquals(5.0, p1.distance(p2), 0.001);
    }

    // Test per il metodo toString
    @Test
    public void testToString() {
        Point p = new Point(1, 2);
        assertEquals("Point{x=1.0, y=2.0}", p.toString());
    }

    // Test per il metodo equals
    @Test
    public void testEquals() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 1);

        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
    }

    // Test per il metodo hashCode
    @Test
    public void testHashCode() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);

        assertEquals(p1.hashCode(), p2.hashCode());
    }

}
