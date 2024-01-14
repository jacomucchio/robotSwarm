package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.BasicLabel;
import it.unicam.cs.pa.robotSwarm.model.Circle;
import it.unicam.cs.pa.robotSwarm.model.ILabel;
import it.unicam.cs.pa.robotSwarm.model.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleTest {
    private Circle circle;
    private Point center;
    private double radius;
    private ILabel label;

    @BeforeEach
    public void setUp() {
        center = new Point(1, 1);
        radius = 5.0;
        label=new BasicLabel("_A");
        circle = new Circle(center, radius, label);
    }

    @Test
    public void testConstructor() {
        assertEquals(center, circle.getCenter());
        assertEquals(radius, circle.getRadius(), 0.01);
        assertEquals(label, circle.getLabel());
    }

    @Test
    public void testContainsPoint() {
        Point insidePoint = new Point(3, 3);
        assertTrue(circle.containsPoint(insidePoint));

        Point outsidePoint = new Point(10, 10);
        assertFalse(circle.containsPoint(outsidePoint));
    }

    @Test
    public void testGetters() {
        assertEquals(center, circle.getCenter());
        assertEquals(radius, circle.getRadius(), 0.01);
        assertEquals(label, circle.getLabel());
    }
}
