package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.BasicLabel;
import it.unicam.cs.pa.robotSwarm.model.ILabel;
import it.unicam.cs.pa.robotSwarm.model.Rectangle;
import it.unicam.cs.pa.robotSwarm.model.Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {
    private Rectangle rectangle;
    private ILabel label;
    private Point center;
    private double width;
    private double height;

    @BeforeEach
    public void setUp() {
        label=new BasicLabel("_A");
        center = new Point(5, 5);
        width = 10;
        height = 6;
        rectangle = new Rectangle(label, center, width, height);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals(label, rectangle.getLabel());
        assertEquals(center, rectangle.getCenter());
        assertEquals(width, rectangle.getWidth());
        assertEquals(height, rectangle.getHeight());
    }

    @Test
    public void testContainsPoint() {
        // Test con un punto interno
        Point insidePoint = new Point(6, 6);
        assertTrue(rectangle.containsPoint(insidePoint));

        // Test con un punto esterno
        Point outsidePoint = new Point(16, 16);
        assertFalse(rectangle.containsPoint(outsidePoint));
    }
}
