import java.util.HashSet;
import java.util.Scanner;

public class SetExample {
    public static void main(String[] args) {
        HashSet<String> data = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            System.out.print("Student " +i+ " name : ");
            data.add(sc.nextLine());
        }
        System.out.println("Registered students are : ");
        for (String student : data) {
            System.out.println(student);
        }
    }
}
