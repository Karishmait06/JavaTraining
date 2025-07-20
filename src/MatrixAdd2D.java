import java.util.Scanner;

public class MatrixAdd2D {


    public static void main(String[] args) {
        int[][] m1 = new int[2][3];
        int[][] m2 = new int[2][3];

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter values for Matrix 1:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter at [" + i + "][" + j + "]: ");
                m1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter values for Matrix 2:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter at [" + i + "][" + j + "]: ");
                m2[i][j] = sc.nextInt();
            }
        }
        int[][] sum = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sum[i][j] = m1[i][j] + m2[i][j];
            }
        }
        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }

    }
}
