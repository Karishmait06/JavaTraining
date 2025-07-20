package com.shape;

public class Circle extends Shape {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getSurfaceArea() {
        return Math.PI * radius * radius;
    }

    public double getVolume() {
        return 0;  // Circle is 2D
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
