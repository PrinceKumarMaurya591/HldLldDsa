package com.conceptcoding.creationalpatterns.factory.simplefactory;

import com.conceptcoding.creationalpatterns.factory.Circle;
import com.conceptcoding.creationalpatterns.factory.Rectangle;
import com.conceptcoding.creationalpatterns.factory.Square;

enum ShapeType {
    CIRCLE, RECTANGLE, SQUARE
}

// Step 3: Simple Factory Demo (Bloated Design)
public class SimpleFactoryDemo {

    public static void main(String[] args) {

        // set the type you want
        ShapeType type = ShapeType.CIRCLE;

        switch (type) {
            case CIRCLE:
                Circle circle = new Circle();
                circle.draw();
                circle.computeArea();
                break;
            case RECTANGLE:
                Rectangle rectangle = new Rectangle();
                rectangle.draw();
                rectangle.computeArea();
                break;
            case SQUARE:
                Square square = new Square();
                square.draw();
                square.computeArea();
                break;
        }
    }
}
