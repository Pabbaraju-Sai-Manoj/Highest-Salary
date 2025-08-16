import java.util.*;
import java.util.stream.*;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() { return name; }
    public double getSalary() { return salary; }
}

public class EmployeeFilter {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Manoj", 55000),
            new Employee("Pavan", 72000),
            new Employee("Kiran", 45000)
        );


        List<String> highEarners = employees.stream()
            .filter(e -> e.getSalary() > 50000)
            .sorted(Comparator.comparingDouble(Employee::getSalary))
            .map(Employee::getName)
            .collect(Collectors.toList());

        System.out.println("High earning employees: " + highEarners);
    }
}
