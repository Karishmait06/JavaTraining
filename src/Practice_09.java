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
//
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

public class Practice_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius of the cylinder");
        float radius = sc.nextFloat();
        System.out.println("Enter height of the cylinder");
        float height = sc.nextFloat();
        Cylinder cyl = new Cylinder(radius, height);

//        cyl.setRadius(radius);
//        cyl.setHeight(height);
        System.out.println("Radius : " +cyl.getRadius());
        System.out.println("Height : " +cyl.getHeight());
        System.out.println("Surface area : " +cyl.calculateSurfaceArea());
        System.out.println("Volume : " +cyl.calculateVolume());
    }
}
