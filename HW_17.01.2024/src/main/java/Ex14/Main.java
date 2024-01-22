package Ex14;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        List<Company> companies = List.of(
                new Company("Company1", List.of(
                        new Department2("Department1", List.of(
                                new Employee2("Employee1", 2.000),
                                new Employee2("Employee2", 1.34)
                        )),
                        new Department2("Department2", List.of(
                                new Employee2("Employee3", 12.0034),
                                new Employee2("Employee4", 8.907)
                        ))
                )),
                new Company("Company2", List.of(
                        new Department2("Department3", List.of(
                                new Employee2("Employee5", 1.2345),
                                new Employee2("Employee6", 4.567)
                        )),
                        new Department2("Department4", List.of(
                                new Employee2("Employee7", 5.678),
                                new Employee2("Employee8", 7.890)
                        ))
                ))
        );

        Map<String, Double> averageSalaryByCompany = averageSalaryByCompany(companies);

        averageSalaryByCompany.forEach((company, averageSalary) ->
                System.out.println("Company: " + company + ", Average Salary: " + averageSalary)
        );
    }
    public static Map<String, Double> averageSalaryByCompany(List<Company> companies) {
//        return companies.stream()
//                .map(Company::getName)
//                .flatMap(List::stream)
//                .map(Department2::getName)
//                .flatMap(List::stream)
//                .collect(Collectors.groupingBy(Employee2::getName, Collectors.averagingDouble(Employee2::getSalary)));
//    }
        return companies.stream()
                .collect(Collectors.toMap(
                        Company::getName,
                        company -> company.getDepartments().stream()
                                .flatMap(department -> department.getEmployees().stream())
                                .collect(Collectors.averagingDouble(Employee2::getSalary))
                ));
    }
}
