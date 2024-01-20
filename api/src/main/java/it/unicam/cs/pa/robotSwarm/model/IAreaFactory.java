package it.unicam.cs.pa.robotSwarm.model;

import it.unicam.cs.followme.utilities.ShapeData;
/**
 * Interface for a factory that creates {@code IArea} objects.
 * Implementations of this interface are responsible for converting
 * {@code ShapeData} into concrete instances of {@code IArea}.
 */
public interface IAreaFactory {
    /**
     * Creates an {@code IArea} instance based on the provided {@code ShapeData}.
     * The implementation of this method should interpret the {@code ShapeData}
     * and instantiate an appropriate {@code IArea} object based on the shape type
     * and its specific parameters contained within the {@code ShapeData}.
     *
     * @param shapeData The {@code ShapeData} object containing information
     *                  about the shape type and its parameters.
     * @return An instance of {@code IArea} corresponding to the information
     *         provided in {@code ShapeData}.
     */
    IArea createArea(ShapeData shapeData);
}
