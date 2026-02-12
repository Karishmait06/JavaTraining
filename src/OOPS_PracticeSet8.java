
class Employee {
    int salary;
    int id;
    private String name;

    public int getSalary() {
        return salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String empName) {
        name = empName;
    }
}

class cellPhone {
    public void ringing() {
        System.out.println("Cellphone Ringing!");
    }
    public void vibrating() {
        System.out.println("Cellphone Vibrating!");
    }
}

class Square {



    public void getArea(int side) {
        System.out.println("Area of square with side " +side+ " is : " +side*side);
    }

    public void getPerimeter(int side) {
        System.out.println("Perimeter of square with side " +side+ " is : " +4*side);
    }

}

class Rectangle{
    public void getArea(int length, int breadth) {
        System.out.println("Area of reactangle with length " +length+ " and breadth " +breadth+ " is : " +length*breadth);
    }

    public void getPerimeter(int length, int breadth) {
        System.out.println("Perimeter of reactangle with length " +length+ " and breadth " +breadth+ " is : " +2*(length+breadth));
    }
}

class TommyVecetti {
 public void hit() {
    System.out.println("Hitting the enemy!");
 }
 public void run() {
    System.out.println("Running from the enemy!");
 }
    public void fire() {
        System.out.println("Firing on the enemy!");
    }
}

public class OOPS_PracticeSet8 {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.id = 1;
        emp.setName("Karishma");
        emp.salary = 30;
        System.out.println("Employee name is : " +emp.getName()+ " and salary is : " + emp.getSalary());

        cellPhone cell = new cellPhone();
        cell.ringing();
        cell.vibrating();

        Square sq = new Square();
        sq.getArea(10);
        sq.getPerimeter(10);

        Rectangle rect = new Rectangle();
        rect.getArea(10,20);
        rect.getPerimeter(10,20);

        TommyVecetti tommy = new TommyVecetti();
        tommy.hit();
        tommy.run();
        tommy.fire();

    }
}
