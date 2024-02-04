package it.unicam.cs.pa.robotSwarm.utils;

import it.unicam.cs.followme.utilities.ShapeData;
import it.unicam.cs.pa.robotSwarm.model.*;

/**
 * Implementation of the {@code IAreaFactory} interface for creating instances of {@code Circle}.
 */
public class CircleFactory implements IAreaFactory {

    /**
     * Creates a circular area based on the provided {@code ShapeData}.
     *
     * @param shapeData The data representing the shape, including center coordinates, radius, and label.
     * @return A new instance of {@code Circle} created from the provided shape data.
     */
    @Override
    public IArea createArea(ShapeData shapeData) {
        Point center = new Point(shapeData.args()[0], shapeData.args()[1]);
        double radius = shapeData.args()[2];
        ILabel label = new BasicLabel(shapeData.label());
        return new Circle(center, radius, label);
    }
}
