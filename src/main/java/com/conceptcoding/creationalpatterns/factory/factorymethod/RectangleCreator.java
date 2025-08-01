package com.conceptcoding.creationalpatterns.factory.factorymethod;

import com.conceptcoding.creationalpatterns.factory.Rectangle;
import com.conceptcoding.creationalpatterns.factory.Shape;

// Step 4: Concrete Creator classes
public class RectangleCreator extends ShapeFactory {

    @Override
    public Shape getShapeInstance() {
        return new Rectangle();
    }
}
