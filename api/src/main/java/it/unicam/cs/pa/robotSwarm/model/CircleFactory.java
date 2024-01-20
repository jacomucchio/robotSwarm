package it.unicam.cs.pa.robotSwarm.model;

import it.unicam.cs.followme.utilities.ShapeData;

public class CircleFactory implements IAreaFactory{
    @Override
    public IArea createArea(ShapeData shapeData) {
        Point center = new Point(shapeData.args()[0], shapeData.args()[1]);
        double radius = shapeData.args()[2];
        ILabel label = new BasicLabel(shapeData.label());
        return new Circle(center, radius, label);
    }
}
