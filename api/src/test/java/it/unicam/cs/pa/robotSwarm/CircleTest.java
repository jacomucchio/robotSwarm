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
    @Test
    void shouldCreateCircleWithValidParameters() {
        Point center = new Point(0, 0);
        double radius = 5.0;
        ILabel label = new BasicLabel("_CircleLabel");

        Circle circle = new Circle(center, radius, label);

        assertEquals(center, circle.getCenter());
        assertEquals(radius, circle.getRadius());
        assertEquals(label, circle.getLabel());
    }

    @Test
    void shouldContainPointInsideCircle() {
        Point center = new Point(0, 0);
        double radius = 5.0;
        ILabel label = new BasicLabel("_CircleLabel");
        Circle circle = new Circle(center, radius, label);

        assertTrue(circle.containsPoint(new Point(3, 4)));
    }

    @Test
    void shouldNotContainPointOutsideCircle() {
        Point center = new Point(0, 0);
        double radius = 5.0;
        ILabel label = new BasicLabel("_CircleLabel");
        Circle circle = new Circle(center, radius, label);

        assertFalse(circle.containsPoint(new Point(8, 8)));
    }

}
