package it.unicam.cs.pa.robotSwarm.model;

import it.unicam.cs.followme.utilities.ShapeData;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory class for creating instances of {@code IArea} based on {@code ShapeData}.
 * This factory supports different types of shapes such as circles and rectangles.
 */
public class ShapeDataAreaFactory {
    /** Mapping of shape types to corresponding area factories. */
    private static final Map<String, IAreaFactory> factoryMap = new HashMap<>();

    static {
        factoryMap.put("CIRCLE", new CircleFactory());
        factoryMap.put("RECTANGLE", new RectangleFactory());
    }
    /**
     * Creates an area based on the provided {@code ShapeData}.
     *
     * @param shapeData The data representing the shape, including type and parameters.
     * @return A new instance of {@code IArea} created from the provided shape data.
     * @throws IllegalArgumentException If the shape type is not supported.
     */
    public IArea createArea(ShapeData shapeData) {
        IAreaFactory factory = factoryMap.get(shapeData.shape());
        if (factory != null) {
            return factory.createArea(shapeData);
        } else {
            throw new IllegalArgumentException("Unsupported shape type: " + shapeData.shape());
        }
    }
}
