package it.unicam.cs.pa.robotSwarm.utils;

import it.unicam.cs.followme.utilities.ShapeData;
import it.unicam.cs.pa.robotSwarm.model.*;

/**
 * Implementation of the {@code IAreaFactory} interface for creating instances of {@code Rectangle}.
 */
public class RectangleFactory implements IAreaFactory {
    /**
     * Creates a rectangular area based on the provided {@code ShapeData}.
     *
     * @param shapeData The data representing the shape, including center coordinates, width, height, and label.
     * @return A new instance of {@code Rectangle} created from the provided shape data.
     */
    @Override
    public IArea createArea(ShapeData shapeData) {
        Point center = new Point(shapeData.args()[0], shapeData.args()[1]);
        double width = shapeData.args()[2];
        double height = shapeData.args()[3];
        ILabel label = new BasicLabel(shapeData.label());
        return new Rectangle(label, center, width, height);
    }
}
