// Java lambda expression can implement interfaces with 
// a single unimplemented method, known as abstract method. These interfaces are called functional interfaces.
// but as many default and static methods as you want. 
// They can also have overridden methods from Object class,
//  but they don't count towards the single abstract method requirement.


@FunctionalInterface // Annotation to indicate that this interface is intended to be a functional interface
interface Printer {
    void print();
}

@FunctionalInterface
interface Adder{
    int add(int a , int b);
}

@FunctionalInterface
interface EvenChecker {
    boolean isEven(int num);
}

@FunctionalInterface
interface StringComparator {
    boolean isFirstLonger(String a, String b);
}

public class LambdaExp {
    public static void main(String[] args) {
        Printer p = () -> System.out.println("Hello");
        p.print();

        Adder ad = (a,b) ->  a+b;
        System.out.println(ad.add(5,5));

        EvenChecker e = (num) -> num%2 == 0;
        System.out.println(e.isEven(6));

        StringComparator sc = (a,b) -> a.length() > b.length();
        System.out.println(sc.isFirstLonger("Luffy", "Shanks" ));

    }
}
