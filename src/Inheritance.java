
class Animal {
    public void printLine() {
        System.out.println("I am base class Animal");
    }
}

class Dog extends Animal {
    public void printText() {
        System.out.println("I am derived class dog");
    }
}


public class Inheritance {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.printLine();
        d.printText();

    }
}
