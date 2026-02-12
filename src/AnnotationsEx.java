//Annotations are metadata — extra information you can attach to your code.
//They don’t change how your code executes but tell tools / compilers / frameworks how to process your code.

// A custom annotation is a user-defined metadata tag you attach to code elements like:

// ✔ Methods
// ✔ Classes
// ✔ Fields

// @Retention Controls how long annotation exists - RUNTIME, CLASS, SOURCE
// SOURCE → Annotation exists only in source code and is discarded by the compiler.
// CLASS → Annotation is stored in the .class file but not available at runtime via reflection.
// RUNTIME → Annotation is retained in the .class file and accessible at runtime through reflection.

// @Target Specifies where annotation can be applied - METHOD, FIELD, TYPE (class/interface), etc.

// Reflection checks:

// ✔ Does method have annotation?
// ✔ If yes → fetch annotation instance
// ✔ Read annotation values



import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Important {}

@Important
class Example {
    void criticalTask() {
        System.out.println("Critical task executed");
    }

    void regularTask() {
        System.out.println("Regular task executed");
    }
}

public class AnnotationsEx{

    public static void main(String[] args) throws Exception {

        Example ex = new Example();
        // for (Method m : Example.class.getDeclaredMethods()) {

            if (Example.class.isAnnotationPresent(Important.class)) {
                System.out.println("Important task detected!");
                for(Method m : Example.class.getDeclaredMethods()) {
                    m.invoke(ex);
                }
            }

           
        // }
    }
}