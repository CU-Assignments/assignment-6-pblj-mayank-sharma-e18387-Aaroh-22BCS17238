import java.util.*;

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Emma", 85),
                new Student("Liam", 72),
                new Student("Olivia", 90),
                new Student("Noah", 78));

        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingInt(Student::getMarks).reversed())
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
