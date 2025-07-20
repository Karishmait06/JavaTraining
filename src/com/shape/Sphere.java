package com.shape;

public class Sphere extends Circle {

    public Sphere(double radius) {
        super(radius);
    }

    public double getSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}
