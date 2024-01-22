package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);

        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println();

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers2.stream()
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
        System.out.println();

        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers3.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .ifPresent(System.out::println);
        System.out.println();

        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");

        List<Integer> integers = strings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(integers);
        System.out.println();

        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi");
        List<String> filtereUpper = words.stream()
                .filter(w -> w.startsWith("a"))
                .map(String::toUpperCase)
                .toList();
        System.out.println(filtereUpper);

        List<String> uniqueWords = words.stream()
                .filter(word -> word.chars()
                        .mapToObj(c -> (char) c)
                        .distinct()
                        .count() == word.length())
                .collect(Collectors.toList());
        System.out.println(uniqueWords);
        System.out.println();

        m1();
        System.out.println();
        m2();
        System.out.println();
        m3();
        System.out.println();
        m6();
        System.out.println();
        m7();
        System.out.println();
        m8();
        System.out.println();
        m9();


    }
        private static void m1(){
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            List<Integer> oddNumbers = numbers.stream()
                    .filter(number -> number % 2 != 0)
                    .toList();
            System.out.println("Нечетные числа: " + oddNumbers);
        }
        private static void m2(){
            List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
            List<Integer> integers = strings.stream()
                    .map(Integer::parseInt)
                    .toList();
            System.out.println("Список чисел: " + integers);
        }
        private static void m3(){
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
            int sum = numbers.stream()
                    .reduce(0, Integer::sum);
            System.out.println("Сумма чисел: " + sum);
        }
    private static void m6(){
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi", "cherry", "kiwi");

        List<String> uniqueWords = words.stream()
                .filter(word -> word.length() > 4)
                .distinct()
                .toList();
        System.out.println(uniqueWords);
    }

    private static void m7() {
        List<Person> people = Arrays.asList(new Person("John", 25), new Person("Alice", 22), new Person("Bob", 30));
        List<String> sorted = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .map(person -> person.getName() + ": " + person.getAge())
                .toList();
        System.out.println("Имена отсортированные по возрасту:");
        sorted.forEach(System.out::println);
    }
    private static void m8(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }

    private static void m9() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi", "grape");
        List<String> uniqueWords = words.stream()
                .filter(word -> word.chars()
                        .mapToObj(c -> (char) c)
                        .distinct()
                        .count() == word.length())
                .toList();
        System.out.println(uniqueWords);
    }
}
