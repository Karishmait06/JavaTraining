import java.util.Scanner;


public class Recursion {
    static void multiply(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n+ " x " +i+ " = " +n*i);
        }
    }

    static int naturalSum(int n) {
        if (n == 1) return 1;
        return n + naturalSum(n - 1);

    }

    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n-1) + fibonacci(n -2);
    }

    static int printPattern(int n) {
            return n;
    }


    public static void main(String[] args) {
//        multiply(5);

        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

//        for(int i = 0; i < 5; i++) {
//            for (int j = 5; j > i; j--) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        int n = 10;
//        int result = naturalSum(n);
//        System.out.println("Sum of first " + n + " natural numbers = " + result);

//        int n = 10;
//        for (int i = 0; i < n; i++) {
//            System.out.print(fibonacci(i) + " ");
//        }


    }
}
