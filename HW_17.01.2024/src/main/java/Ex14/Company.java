package Ex14;

import java.util.List;

public class Company {
    private String name;
    private List<Department2> departments;

    public Company(String name, List<Department2> departments) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public List<Department2> getDepartments() {
        return departments;
    }
}
