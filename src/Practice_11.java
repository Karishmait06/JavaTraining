
interface BasicAnimal {
    void eat();
    void sleep();
}
 abstract class Pen {
   abstract void write();
   abstract void refill();
}

class Monkey {
    void jump() {
        System.out.println("Monkey can jump");
    }
    void bite() {
        System.out.println("Monkey can bite");
    }
}

class Human extends Monkey implements BasicAnimal {

    @Override
    public void jump() {
        System.out.println("Human can jump");
    }

    @Override
    public void bite() {
        System.out.println("Human can bite");
    }
    public void eat() {
        System.out.println("Human can eat");
    }
    public void sleep() {
        System.out.println("Human can sleep");
    }
}

class Fountain extends Pen {
    public void write() {
        System.out.println("Writing from fountain pen");
    }
    public void refill() {
        System.out.println("Refilling fountain pen");
    }
    public void changeNib() {
        System.out.println("Changing nib of Fountain pen");
    }
}



public class Practice_11 {
    public static void main(String[] args) {
        Fountain p = new Fountain();
        p.write();
        p.refill();
        p.changeNib();

        Human h = new Human();
        h.eat();
        h.sleep();
        h.jump();
        h.bite();
    }
}
