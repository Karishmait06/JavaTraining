interface Greeting {
    public void greet();
    public void sayThankYou();
}


public class AnonymousClass {
    public static void main(String[] args) {
        Greeting english = new Greeting() {
            @Override
            public void greet() {
                System.out.println("Hello!");
            }

            @Override
            public void sayThankYou() {
                System.out.println("Thank you so much!");
            }
        };

        Greeting japanese = new Greeting() {
            @Override
            public void greet() {
                System.out.println("Konichiwa!");
            }

            @Override
            public void sayThankYou() {
                System.out.println("Arigatou gozaimasu!");
            }
        };
        english.greet();
        english.sayThankYou();
        japanese.greet();
        japanese.sayThankYou();

    }
}
