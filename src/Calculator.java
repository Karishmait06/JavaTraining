import java.util.Scanner;

class MaxInputExp extends Exception {
    @Override
    public String toString() {
        return "Input should not exceed more than 100000";
    }
}

class InvalidOperatorExp extends Exception {
    @Override
    public String toString() {
        return "Invalid operator!";
    }
}

class CannotDivideByZeroExp extends Exception {
    @Override
    public String toString() {
        return "Cannot divide by zero";
    }
}

class MaxMultiplierExp extends Exception {
    @Override
    public String toString() {
        return "Multiplier cannot be greater than 7000";
    }
}

public class Calculator {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int attempts = 0;
        int maxTry = 5;
       while(attempts < maxTry) {
           try {
               System.out.println("👉 Attempt " + (attempts + 1) + "/" + maxTry);
               System.out.println("Enter first operand");
               double a = sc.nextDouble();
               System.out.println("Enter second operand");
               double b = sc.nextDouble();
               System.out.println("Enter operator");
               String operator = sc.next();
               if(a > 100000 || b > 100000) {
                   throw new MaxInputExp();
               }

               switch (operator) {
                   case "+" :
                       System.out.println(a+b);
                       break;
                   case "-" :
                       System.out.println(a-b);
                       break;
                   case "*" :
                       if(a > 7000 || b > 7000) {
                           throw new MaxMultiplierExp();
                       }else {
                           System.out.println(a*b);
                       }
                       break;
                   case "/" :
                       if (b == 0) {
                           throw new CannotDivideByZeroExp();
                       }else {
                           System.out.println(a/b);
                       }
                       break;
                   default: throw new InvalidOperatorExp();
               }
           } catch (Exception e){
               System.out.println("Error occurred " +e);
           } finally {
               attempts++;
           }
       }
       throw new Exception();
    }
}
