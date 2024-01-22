package Ex12;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Department> departments = Arrays.asList(
                new Department("HR", Arrays.asList(new Employee("John", 50.456), new Employee("Alice", 60.678))),
                new Department("IT", Arrays.asList(new Employee("Bob", 70.987), new Employee("Eve", 80.345)))
        );

        String departmentName = "IT";
        double totalSalary = getTotalSalaryByDepartment(departments, departmentName);

        System.out.println("Total salary in department " + departmentName + ": " + totalSalary);


    }

    public static double getTotalSalaryByDepartment(List<Department> departments, String departmentName) {
        return departments.stream()
                .filter(department -> department.getName().equals(departmentName))
                .flatMap(department -> department.getEmployees().stream())
                .mapToDouble(Employee::getSalary)
                .sum();
    }
}
