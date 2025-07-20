import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Arraylist {
    public static void main(String[] args) {
//        ArrayList<Integer> l1 = new ArrayList<>();
//        LinkedList<Integer> l2 = new LinkedList<>();
//        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
//        l1.add(3);
//        l1.add(4);
//        l1.add(5);
//        l1.add(6);
//        l1.add(10);
//
//        l2.add(30);
//        l2.add(40);
//        l2.add(50);
//        l2.add(60);
//        System.out.println(l2.peek());
//        System.out.println(l2.pollFirst());
//        System.out.println(l2.getLast());
//        System.out.println(l1.isEmpty());
//        System.out.println(l1.subList(2,5));
//        ad1.add(3);
//        ad1.add(4);
//        ad1.add(5);
//        ad1.add(6);
//        ad1.add(10);
//        ad1.addFirst(55);
//        ad1.removeLast();
//        System.out.println(ad1.getFirst());
//        System.out.println(ad1.getLast());

        ArrayList<String> students = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            System.out.print("Student " +i+ " name : ");
            students.add(sc.nextLine());
        }
        System.out.println("Registered students are : ");
        for (String student : students) {
            System.out.println(student);
        }

    }
}
