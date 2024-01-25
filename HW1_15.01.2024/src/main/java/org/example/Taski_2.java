package org.example;

import java.lang.reflect.Field;
import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Taski_2 {
    public static void main(String[] args) throws NoSuchFieldException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(sumOfSquaresOfOddNumbers(numbers));
        System.out.println();

        List<String> strings = List.of("apple", "banana", "cherry", "apple", "orange", "grapefruit");
        System.out.println(uniqueSortedWords(strings));
        System.out.println(uniqueChars(strings));
        System.out.println(longestString(strings));

        List<Name> names = List.of(
                new Name("Наталья",31),
                new Name("Андрей",34),
                new Name("Богдан",57)
        );
        List<Name> filteredNames = filterByField(names, "name", "Наталья");
        filteredNames.forEach(obj -> {
            System.out.println("Имя: " + obj.getName() + ", Возраст: " + obj.getAge());
        });

    }

    public static int sumOfSquaresOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 != 0)
                .map(num -> num * num)
                .reduce(0, Integer::sum);
    }

    public static List<String> uniqueSortedWords(List<String> strings) {
        return strings.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> List<T> filterByField(List<T> objects, String fieldName, Object value) throws NoSuchFieldException {
        return objects.stream()
                .filter(obj -> {
                    try {
                        Field field = obj.getClass().getDeclaredField(fieldName);
                        field.setAccessible(true);
                        return field.get(obj).equals(value);
                    } catch (IllegalAccessException | NoSuchFieldException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());

        }

    public static List<String> uniqueChars(List<String> strings) {
        return strings.stream()
                .map(str -> str.chars()
                        .distinct()
                        .mapToObj(c -> String.valueOf((char) c))
                        .collect(Collectors.joining(", ", "[", "]")))
                .collect(Collectors.toList());
    }
    public static String longestString(List<String> strings){
        return strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(" ");
    }
    public static <T> double averageFieldValue(List<T> objects, String fieldName) throws NoSuchFieldException{
        return objects.stream()
                .map(obj -> {
                    try {
                        Field field = obj.getClass().getDeclaredField(fieldName);
                        field.setAccessible(true);
                        return field.get(obj);
                        } catch (IllegalAccessException | NoSuchFieldException e) {
                            throw new RuntimeException(e);
                    }
                })
                .mapToInt(value -> (int) value)
                .average()
                .orElse(0);
    }
}