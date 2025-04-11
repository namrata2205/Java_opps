import java.util.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + " - " + marks;
    }
}

public class SortStudents {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Ram", 85),
            new Student("Shyam", 92),
            new Student("Mina", 76)
        );

        students.sort(Comparator.comparingInt(s -> s.marks));
        students.forEach(System.out::println);
    }
}
