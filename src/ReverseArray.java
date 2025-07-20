import java.util.Scanner;
import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int size = sc.nextByte();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " +(i +1)+ " : ");
            arr[i] = sc.nextInt();
        }

        int[] result = new int[arr.length];
        boolean isSorted = false;
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
            isSorted = i > 0 &&  arr[i - 1] < arr[i];
        }

        int max = arr[0];
        int min = arr[0];

        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }

        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }


        System.out.println("Reverse of " + Arrays.toString(arr) + " is " + Arrays.toString(result));
        System.out.println("Maximum number is : " +max+ " and Minimum number is : "+min);
        System.out.println("Array is sorted : " +isSorted);
        System.out.println("Method Overloading");
    }
}
