package it.unicam.cs.pa.robotSwarm.model;

import it.unicam.cs.followme.utilities.ShapeData;

import java.util.HashMap;
import java.util.Map;

public class ShapeDataAreaFactory {
    private static final Map<String, IAreaFactory> factoryMap = new HashMap<>();

    static {
        factoryMap.put("CIRCLE", new CircleFactory());
        factoryMap.put("RECTANGLE", new RectangleFactory());
    }
    public IArea createArea(ShapeData shapeData) {
        IAreaFactory factory = factoryMap.get(shapeData.shape());
        if (factory != null) {
            return factory.createArea(shapeData);
        } else {
            throw new IllegalArgumentException("Tipo di forma non supportato: " + shapeData.shape());
        }
    }
}
