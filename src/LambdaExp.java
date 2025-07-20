
@FunctionalInterface
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
