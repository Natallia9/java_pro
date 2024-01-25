package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = Stream.of("abs", "brg", "cgh", "brg", "abs", "jkl")
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println();

        Set<Integer> duplicate = Stream.of(25, 45, 33, 25, 67, 89, 33)
                .collect(Collectors.toSet());
        System.out.println(duplicate);
//        List<String> duplicate2 = Arrays.asList("abs", "brg", "cgh", "brg", "abs", "jkl");
//        duplicate2.stream()
//                        .distinct()
//                                .collect(Collectors.toList());
//        System.out.println(duplicate2);
        System.out.println();

        List<String> words = Arrays.asList("apple", "banana", "pear", "grape", "kiwi", "orange", "banana", "kiwi");
        Map<Integer, List<String>> grouped = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(grouped);
        System.out.println();

        Map<String, Long> repeat = words.stream()
                .collect(Collectors.groupingBy(el -> el, Collectors.counting()))
                        .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(repeat);
        System.out.println();

        List<String> uniqueWords = words.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueWords);
        System.out.println();

        String stringMax = list.stream()
                .collect(Collectors.joining(", "));
        System.out.println(stringMax);
        System.out.println();

        String word = "Banana";
        Set<Character> chars = word.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        System.out.println(chars);
        System.out.println();

        Map<String, Integer> custom = words.stream()
                .distinct()
                .collect(Collectors.toMap(w -> w, String::length));
        System.out.println(custom);
        System.out.println();

        List<Students> studentsList = List.of(
                new Students("Наталья", "Иванова", 31),
                new Students("Андрей", "Иванов", 34),
                new Students("Богдан", "Петров", 57)
        );
        int sumOfAges = studentsList.stream()
                .collect(Collectors.summingInt(Students::getAge));

        System.out.println("Сумма возрастов студентов: " + sumOfAges);
        System.out.println();

        Map<String, Double> averageValue = studentsList.stream()
                .collect(Collectors.groupingBy(Students::getFirstName, Collectors.averagingInt(Students::getAge)));
        System.out.println(averageValue);

    }
}