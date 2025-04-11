import java.lang.reflect.*;

class Sample {
    public int id = 10;
    public void greet() { System.out.println("Hello from Sample"); }
}

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Sample s = new Sample();
        Class<?> cls = s.getClass();

        for (Field f : cls.getDeclaredFields()) {
            System.out.println("Field: " + f.getName());
        }

        for (Method m : cls.getDeclaredMethods()) {
            System.out.println("Method: " + m.getName());
        }

        Method method = cls.getDeclaredMethod("greet");
        method.invoke(s);
    }
}
