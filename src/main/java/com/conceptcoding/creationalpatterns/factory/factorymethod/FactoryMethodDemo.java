package com.conceptcoding.creationalpatterns.factory.factorymethod;

// Step 5: Client code demonstration
public class FactoryMethodDemo {

    public static void main(String[] args) {

        ShapeFactory shapeFactory;

        // Circle
        shapeFactory = new CircleCreator();
        shapeFactory.performOperations();

        // Rectangle
        shapeFactory = new RectangleCreator();
        shapeFactory.performOperations();

        // Square
        shapeFactory = new SquareCreator();
        shapeFactory.performOperations();

    }
}
