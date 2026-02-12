import com.calculator.Calculator;
import com.calculator.ScCalculator;
import com.calculator.HybridCalculator;

public class Package {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Addition: " + calc.add(5, 3));
        System.out.println("Subtraction: " + calc.subtract(5, 3));
        System.out.println("Multiplication: " + calc.multiply(5, 3));
        System.out.println("Division: " + calc.divide(5, 3));

        ScCalculator sc = new ScCalculator();
        System.out.println("Power: " + sc.power(2, 3));
        
        HybridCalculator hc = new HybridCalculator();
        System.out.println("Square Root: " + hc.squareRoot(16));
    }
}

