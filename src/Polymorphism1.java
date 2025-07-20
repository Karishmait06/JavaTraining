
//Create a class Telephone with ring, lift and disconnect methods as abstract methods. Create another class SmartTelephone
// and dempnstrate polymorphism

abstract class Telephone {
    abstract void ring();
    abstract void lift();
    abstract void disconnect();
}

class SmartTelephone extends Telephone{
    public void ring () {
        System.out.println("Call ringing");
    }
    public void lift () {
        System.out.println("Call lifted");
    }
    public void disconnect () {
        System.out.println("Call disconnected");
    }
}

public class Polymorphism1 {
    public static void main(String[] args) {
//        SmartTelephone st = new SmartTelephone();
//        st.ring();
//        st.lift();
//        st.disconnect();
        Telephone t = new SmartTelephone();
        t.ring();
        t.lift();
        t.disconnect();
    }
}
