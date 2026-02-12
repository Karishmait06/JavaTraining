import java.util.Scanner;

class Cylinder {
    private float radius;
    private float height;

    public Cylinder (float r, float h) {
        this.radius = r;
        this.height = h;
    }

//    public void setRadius(float n) {
//        radius = n;
//    }

//    public void setHeight(float n) {
//        height = n;
//    }

    public float getRadius() {
        return radius;
    }

    public float getHeight() {
        return height;
    }

    public float calculateSurfaceArea() {
        return (float) ((2 * Math.PI * radius * height) + (2 * Math.PI * radius * radius));
    }

    public float calculateVolume() {
        return (float) (Math.PI * radius * radius *height);
    }

}

class Rectangle {
    private float length;
    private float breadth;

    public Rectangle(float l, float b) {
        this.length = l;
        this.breadth = b;
    }

    public Rectangle() {
        length = 4;
        breadth = 5;
    }

    public float getLength() {
        return length;
    }

    public float getBreadth() {
        return breadth;
    }

    public float calculateArea() {
        return length * breadth;
    }

    public float calculatePerimeter() {
        return 2 * (length + breadth);
    }
}

public class Practice_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius of the cylinder");
        float radius = sc.nextFloat();
        System.out.println("Enter height of the cylinder");
        float height = sc.nextFloat();
        Cylinder cyl = new Cylinder(radius, height); // setting value using constructor

    //    cyl.setRadius(radius); // setting value using setter method
    //    cyl.setHeight(height); // setting value using setter method
        System.out.println("Radius : " +cyl.getRadius());
        System.out.println("Height : " +cyl.getHeight());
        System.out.println("Surface area : " +cyl.calculateSurfaceArea());
        System.out.println("Volume : " +cyl.calculateVolume());

        Rectangle rect = new Rectangle(); // using default constructor
        System.out.println("Length : " +rect.getLength());
        System.out.println("Breadth : " +rect.getBreadth());
        System.out.println("Area : " +rect.calculateArea());     

        Rectangle rect2 = new Rectangle(10, 20); // using parameterized constructor
        System.out.println("Length : " +rect2.getLength());
        System.out.println("Breadth : " +rect2.getBreadth());
        System.out.println("Area : " +rect2.calculateArea());
        System.out.println("Perimeter : " +rect2.calculatePerimeter());
    

    }
}
