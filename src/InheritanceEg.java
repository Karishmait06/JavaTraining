

import java.util.Scanner;

class Circle {

    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    public float getRadius () {
        return radius;
    }
    public void setRadius (float radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Cylinder1 extends Circle {
    private float height;

    public Cylinder1(float radius, float height) {
        super(radius);
        this.height = height;
    }
    public float getHeight () {
       return height;
    }
    public void setHeight (float height) {
        this.height = height;
    }
    public float getSurfaceArea() {
        return (float) ((2 * Math.PI * getRadius() * height) + (2 * Math.PI * getRadius() * getRadius()));
    }

    public float getVolume() {
        return (float) (Math.PI * getRadius() * getRadius() * height);
    }

}

public class InheritanceEg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius");
        float radius = sc.nextFloat();
        System.out.println("Enter height");
        float height = sc.nextFloat();
        Cylinder1 cyl = new Cylinder1(radius, height);
        cyl.setRadius(radius);
        cyl.setHeight(height);
        System.out.println("Radius: " + cyl.getRadius());
        System.out.println("Height: " + cyl.getHeight());
        System.out.println("Circle Area: " + cyl.getArea());
        System.out.println("Cylinder Volume: " + cyl.getVolume());
        System.out.println("Cylinder Surface Area: " + cyl.getSurfaceArea());
    }
}
