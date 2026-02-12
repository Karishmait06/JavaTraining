public record Customer(String name, int age) { }

public class Records {
    public static void main(String[] args) {
        Customer c1 = new Customer("Karishma", 25);

        System.out.println(c1.name());
        System.out.println(c1.age());
        System.out.println(c1);
    }
}
