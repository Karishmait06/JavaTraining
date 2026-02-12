// Using reflection at runtime you can:

// ✅ Inspect class details
// ✅ Access fields (even private)
// ✅ Access methods
// ✅ Invoke methods dynamically
// ✅ Read annotations
// ✅ Create objects dynamically


import java.lang.reflect.*;

class Person {

    private String name;
    public int age;

    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greet() {
        System.out.println("Hello, my name is " + name);
    }

    private void secretMethod() {
        System.out.println("This is a private method");
    }
}

public class ReflectionDemo {

    public static void main(String[] args) throws Exception {

        // ✅ Step 1: Get Class object
        Class<?> clazz = Person.class;

        // ✅ Step 2: Create object dynamically
        Object obj = clazz.getDeclaredConstructor().newInstance();

        // ✅ Step 3: Inspect fields
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("Field: " + f.getName());
        }

        System.out.println();

        // ✅ Step 4: Modify private field
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj, "Karishma");

        // ✅ Step 5: Invoke public method
        Method greetMethod = clazz.getMethod("greet");
        greetMethod.invoke(obj);

        // ✅ Step 6: Invoke private method
        Method secret = clazz.getDeclaredMethod("secretMethod");
        secret.setAccessible(true);
        secret.invoke(obj);
    }
}

