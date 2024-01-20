package it.unicam.cs.pa.robotSwarm.model;

import it.unicam.cs.followme.utilities.ShapeData;
import it.unicam.cs.pa.robotSwarm.model.*;

public class RectangleFactory implements IAreaFactory {
    @Override
    public IArea createArea(ShapeData shapeData) {
        Point center = new Point(shapeData.args()[0], shapeData.args()[1]);
        double width = shapeData.args()[2];
        double height = shapeData.args()[3];
        ILabel label = new BasicLabel(shapeData.label());
        return new Rectangle(label, center, width, height);
    }
}
