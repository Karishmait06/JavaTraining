package com.shape;

public class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    public double getSide() {
        return length;
    }

    public void setSide(double side) {
        this.length = side;
        this.breadth = side;
    }
}
