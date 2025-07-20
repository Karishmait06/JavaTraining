
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

public class OOPS {
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

    }
}
