
@FunctionalInterface
interface StringOperation {
    String operate(String s);
    
    default void printOperation(String s) {
        System.out.println("Operating on: " + s);
    }

    static String staticOperation(String s) {
        return "Static: " + s;
    }
}

class LambdaExp1 {
    public static void main(String[] args) {

        String otherText = "Karishma";
        // StringOperation toUpperCase = s -> otherText.toUpperCase(); 
        // //local variables referenced from a lambda expression must be final or effectively final

        StringOperation toUpperCase = s -> s.toUpperCase();

        System.out.println(toUpperCase.operate(otherText));

        StringOperation reverse = s -> new StringBuilder(s).reverse().toString();
        System.out.println(reverse.operate("hello world"));

        StringOperation printfirstThree = s -> s.length() >= 3 ? s.substring(0, 3) : s;
        System.out.println(printfirstThree.operate("hello world"));  

            // Using default method
            toUpperCase.printOperation("hello world");

            // Using static method
            System.out.println(StringOperation.staticOperation("hello world"));

            otherText = "Luffy";
    }
}