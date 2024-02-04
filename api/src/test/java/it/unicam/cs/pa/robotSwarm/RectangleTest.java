package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.BasicLabel;
import it.unicam.cs.pa.robotSwarm.model.ILabel;
import it.unicam.cs.pa.robotSwarm.model.Rectangle;
import it.unicam.cs.pa.robotSwarm.model.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {
    @Test
    void shouldCreateRectangleWithSpecifiedParameters() {
        ILabel label = new BasicLabel("_RectangleLabel");
        Point center = new Point(2.0, 3.0);
        double width = 4.0;
        double height = 5.0;

        Rectangle rectangle = new Rectangle(label, center, width, height);

        assertEquals(label, rectangle.getLabel());
        assertEquals(center, rectangle.getCenter());
        assertEquals(width, rectangle.getWidth());
        assertEquals(height, rectangle.getHeight());
    }

    @Test
    void shouldContainPointInsideRectangle() {
        ILabel label = new BasicLabel("_RectangleLabel");
        Point center = new Point(2.0, 3.0);
        double width = 4.0;
        double height = 5.0;
        Rectangle rectangle = new Rectangle(label, center, width, height);

        assertTrue(rectangle.containsPoint(new Point(3.0, 4.0)));
    }

    @Test
    void shouldNotContainPointOutsideRectangle() {
        ILabel label = new BasicLabel("_RectangleLabel");
        Point center = new Point(2.0, 3.0);
        double width = 4.0;
        double height = 5.0;
        Rectangle rectangle = new Rectangle(label, center, width, height);

        assertFalse(rectangle.containsPoint(new Point(8.0, 8.0)));
    }


}
