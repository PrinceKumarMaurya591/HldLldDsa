package com.conceptcoding.creationalpatterns.factory.factorymethod;


import com.conceptcoding.creationalpatterns.factory.Shape;

// Step 3: Abstract Creator class
public abstract class ShapeFactory {

    // Factory method - to be implemented by subclasses
    public abstract Shape getShapeInstance();

    // Template method that uses the factory method
    public void performOperations() {
        Shape shape = getShapeInstance();
        shape.draw();
        shape.computeArea();
    }
}