import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - Age: " + age + ", Salary: " + salary;
    }
}

public class EmployeeSorter {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Ratnesh", 30, 50000),
                new Employee("Gaurav", 25, 60000),
                new Employee("Vishal", 35, 45000));

        employees.sort(Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getAge)
                .thenComparing(Employee::getSalary));

        employees.forEach(System.out::println);
    }
}
