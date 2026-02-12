class Student {
    private int id;
    private String name;

    public Student setId(int id) {
        this.id = id;
        return this;   // return current object
    }

    public Student setName(String name) {
        this.name = name;
        return this;   // return current object
    }

    public Student show() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        return this;   // can still chain
    }
}

public class MethodChaining {
    public static void main(String[] args) {
        Student s = new Student();

        s.setId(101).setName("Karishma").show();   // method chaining
    }
}
