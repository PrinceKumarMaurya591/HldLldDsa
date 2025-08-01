package com.conceptcoding.creationalpatterns.factory.factorymethod;


import com.conceptcoding.creationalpatterns.factory.Shape;
import com.conceptcoding.creationalpatterns.factory.Square;

// Step 4: Concrete Creator classes
public class SquareCreator extends ShapeFactory {
    @Override
    public Shape getShapeInstance() {
        return new Square();
    }
}
