package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1, 2));
        list.add(List.of(3, 4));
        list.add(List.of(5, 6));
        list.add(List.of(7, 8));
        System.out.println(flattenListOfLists(list));

        Map<String, List<String>> map = new HashMap<>();
        map.put("Key1", List.of("a", "b"));
        map.put("Key2", List.of("c", "d"));
        map.put("Key3", List.of("e", "f"));
        System.out.println(flattenMap(map));

        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        List<String> strings = List.of("a", "b", "c", "d", "e");
        List<Double> doubles = List.of(1.2, 3.04, 5.6, 7.8);

        Function<Number, String> toString = Object::toString;

        System.out.println(combineAndTransform(integers, doubles, toString));

        System.out.println(combineAndTransformComplex(integers, strings, doubles));
    }
    public static List<Integer> flattenListOfLists(List<List<Integer>> listOfLists){
        return listOfLists.stream()
                .flatMap(List::stream)
                .toList();
    }
    public static List<String> getAllSkills(List<User> users){
        return users.stream()
                .flatMap(user -> user.getSkills().stream())
                .toList();
    }
    public static List<String> getAuthorsTitles(List<Book> books){
        return books.stream()
                .flatMap(book -> book.getAuthors().stream())
                .toList();
    }
    public static List<String> flattenMap(Map<String, List<String>> map){
        return map.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
    public static List<Integer> processAndFilter(List<List<Integer>> listOfLists){
        return listOfLists.stream()
                .flatMap(List::stream)
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .toList();
    }
    public static List<String> getLanguagesFromDepartment(List<Employee> employees, String department){
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .flatMap(employee -> employee.getLanguages().stream())
                .toList();
    }
    public static List<Integer> flattenDeepListOfLists(List<List<List<Integer>>> deepList){
        return deepList.stream()
                .flatMap(List::stream)
                .flatMap(List::stream)
                .toList();
    }
    public static List<String> getSortedTasks(List<Project> projects){
        return projects.stream()
                .flatMap(project -> project.getTasks().stream())
                .sorted()
                .toList();
    }
    public static List<String> getUniqueProductNames(Map<String, List<Product>> categoryMap){
        return categoryMap.values().stream()
                .flatMap(List::stream)
                .map(Product::getName)
                .distinct()
                .toList();
    }
    public static List<String> combineAndTransform(List<Integer> list1, List<Double> list2, Function<Number, String> transformer){
        return Stream.concat(list1.stream(), list2.stream())
                .map(transformer)
                .toList();
    }
    public static List<Item> getItemsByCustomerName(List<Order> orders, String customerName){
        return orders.stream()
                .filter(order -> order.getCustomerName().equals(customerName))
                .flatMap(order -> order.getItems().stream())
                .toList();
    }
    public static List<String> combineAndTransformComplex(List<Integer> integers, List<String> strings, List<Double> doubles){
        return Stream.of(integers, strings, doubles)
                .flatMap(List::stream)
                .map(String::valueOf)
                .toList();
    }
}