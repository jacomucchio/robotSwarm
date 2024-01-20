package it.unicam.cs.pa.robotSwarm.model;

import it.unicam.cs.followme.utilities.ShapeData;

public interface IAreaFactory {
    IArea createArea(ShapeData shapeData);
}
