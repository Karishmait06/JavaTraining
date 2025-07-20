

 abstract class Pen {
   abstract void write();
   abstract void refill();
}

class Fountain extends Pen {
    public void write() {
        System.out.println("Writing from fountain pen");
    }
    public void refill() {
        System.out.println("Refilling fountain pen");
    }
    public void changeNib() {
        System.out.println("Changing nin of Fountain pen");
    }
}



public class Practice_11 {
    public static void main(String[] args) {
        Fountain p = new Fountain();
        p.write();
        p.refill();
        p.changeNib();
    }
}
