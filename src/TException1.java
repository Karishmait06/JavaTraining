import java.util.InputMismatchException;
import java.util.Scanner;

class CannotDivideByZeroExp extends Exception {
    @Override
    public String toString() {
        return "Cannot divide by zero!";
    }
}

class MaxRetry extends Exception {
    public MaxRetry(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage(); 
    }
}

public class TException1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int attempts = 0;
        int maxRetries = 5;
        boolean success = false;

        while (attempts < maxRetries) {
            try {
                System.out.print("Enter first number: ");
                int num1 = sc.nextInt();

                System.out.print("Enter second number: ");
                int num2 = sc.nextInt();

                if (num2 == 0) {
                    throw new CannotDivideByZeroExp();
                }

                System.out.println("Result: " + (num1 / num2));
                success = true;
                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine();

            } catch (CannotDivideByZeroExp e) {
                System.out.println(e);

            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }

            attempts++;
            System.out.println("Attempts left: " + (maxRetries - attempts));
            System.out.println();
        }

        sc.close();

        if (!success) {
            try {
                throw new MaxRetry("Maximum number of attempts reached!");
            } catch (MaxRetry e) {
                System.out.println(e);
            }
        }
    }
}
