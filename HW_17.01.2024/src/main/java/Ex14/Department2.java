package Ex14;

import java.util.List;

public class Department2 {
        private String name;
        private List<Employee2> employees;

    public Department2(String name, List<Employee2> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public List<Employee2> getEmployees() {
        return employees;
    }
}
