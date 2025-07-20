/*
Design a console-based Java application to manage student records and generate report cards.
 The system should allow users to add students,
 view individual reports, and display all student report cards.
 Use OOP principles in your implementation:
 */

import java.util.HashMap;
import java.util.Scanner;

// ---------- Interfaces ----------
interface Gradable {
    String getGrade();
}

interface Printable {
    void printReport();
}

abstract class Person {
    protected final String name;
    protected Person(String name) { this.name = name; }
    public String getName() { return name; }
}

class Student extends Person implements Gradable,Printable{

    protected final float sub1;
    protected final float sub2;
    protected final float sub3;
    float total, average;
    String grade;

    Student(String name, float sub1, float sub2, float sub3) {
        super(name);
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        calculateTotal();
        calculateAverage();
        calculateGrade();
    }

    void calculateTotal() {
        total = sub1+sub2+sub3;
        System.out.println("Total marks is : " +total);
    }

    void calculateAverage() {
        average = total/3;
        System.out.println("Average is : " +average);
    }

    void calculateGrade() {
        if (average >= 90) {
            grade = "A";
        } else if (average >= 75) {
            grade = "B";
        } else if (average >= 50) {
            grade = "C";
        } else {
            grade = "F";
        }
    }

    @Override
    public String  getGrade() {
        return grade;
    }

    @Override
    public void printReport() {
        System.out.printf("%s |  Total: %.1f | Avg: %.1f | Grade: %s%n",
                name, total, average, grade);
    }


    @Override
    public String toString() {
        return name + " has Marks : " + total + " Average : " +average+ " Grade : " +grade;
    }
}

class StudentManager {
    HashMap<String, Student> students = new HashMap<>();

    void addStudent(String name , float sub1, float sub2, float sub3) {
        students.put(name, new Student(name, sub1, sub2, sub3));
    }

    void searchStudent(String name) {
        Student std = students.get(name);
        if (std == null) {
            System.out.println("Student not found");
            return;
        }
        std.printReport();
    }

    void listStudent() {
        if (students.isEmpty()) {
            System.out.println("Class is empty");
            return;
        }
        students.values().forEach(System.out::println);
    }

}
public class StudentReportSystem {
    public static void main(String[] args) {
        StudentManager stm = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Welcome to the Class");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Display all students");
            System.out.println("4. Exit class");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 1-4.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter marks for Subject 1: ");
                    float sub1 = Float.parseFloat(sc.nextLine());
                    System.out.print("Enter marks for Subject 2: ");
                    float sub2 = Float.parseFloat(sc.nextLine());
                    System.out.print("Enter marks for Subject 3: ");
                    float sub3 = Float.parseFloat(sc.nextLine());
                    stm.addStudent(name, sub1, sub2, sub3);
                }
                case 2 -> {
                    System.out.println("Search student by name : ");
                    String name = sc.nextLine();
                    stm.searchStudent(name);
                }
                case 3 -> stm.listStudent();
                case 4 -> {
                    System.out.println("Goodbye class");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid input! Please enter option from 1-4");
            }
        }
    }
}
