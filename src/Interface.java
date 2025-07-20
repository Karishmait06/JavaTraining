//Create an interface SmartTVRemote and use it to inherit another interface TVRemote

interface TVRemote {
    void switchOn();
    void switchOff();
}

interface SmartTVRemote extends TVRemote {
    void volumeUp();
    void volumeDown();
}

class TV implements SmartTVRemote{
    public void switchOn() {
        System.out.println("TV Switched on");
    }
    public void switchOff() {
        System.out.println("TV Switched off");
    }
    public void volumeUp() {
        System.out.println("TV Volume up");
    }
    public void volumeDown() {
        System.out.println("TV Volume down");
    }
}

public class Interface {
    public static void main(String[] args) {
        TV lg = new TV();
        lg.switchOn();
        lg.volumeUp();
        lg.volumeDown();
        lg.switchOff();
    }
}
