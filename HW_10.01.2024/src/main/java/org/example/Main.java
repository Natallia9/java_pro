package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<String> string = List.of("Мария", "Валерий", "Татьяна", "Ольга", "Татьяна");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Character> ch = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'g');

        System.out.println(filterByLength(string, 5));
        System.out.println(toUpperCase(string));
        System.out.println(findFirstStartingWith(string, 'В'));
        System.out.println(joinByComma(string));
        System.out.println(countContainingChar(string, 'я'));
        System.out.println("**********************************************************");
        System.out.println();

        System.out.println(sumOfList(numbers));
        System.out.println(getSquares(numbers));
        System.out.println(filterGreaterThan(numbers, 3));
        System.out.println(containsNumber(numbers, 11));
        System.out.println(findMax(numbers));
        System.out.println("**********************************************************");
        System.out.println();

        System.out.println(convertToStringList(ch));
        System.out.println(filterByAsciiValue(ch, 100));
        System.out.println(areAllUpperCase(ch));
        System.out.println(findFirstDuplicate(ch));
        System.out.println(reverseList(ch));
        System.out.println("***********************************************************");
        System.out.println();

        List<Float> floats = List.of(1.1f, 2.2f, 3.3f, 4.4f, 5.5f, 6.6f, 7.7f, 8.8f, 9.9f);

        System.out.println(findMin(floats));
        System.out.println(multiplyBy(floats, 12));
        System.out.println(filterLessThan(floats, 5.2f));
        System.out.println(containsNegative(floats));
        System.out.println(roundNumbers(floats));
        System.out.println("***********************************************************");
        System.out.println();

        System.out.println(countUnique(string));
        System.out.println(isSorted(numbers));
        System.out.println(getLastElement(string));
        System.out.println(shuffleList(ch));
        System.out.println(countFrequency(ch));

    }

   public static List<String> filterByLength(List<String> input, int length){
        return input.stream().filter(s -> s.length() == length).toList();
    }
    public static List<String> toUpperCase(List<String> input){
        return input.stream().map(String::toUpperCase).toList();
    }
    public static Optional<String> findFirstStartingWith(List<String> input, char letter){
        return input.stream().filter(s -> s.charAt(0) == letter).findFirst();
    }
    public static Optional<String> joinByComma(List<String> input){
        return input.stream().reduce((a, b) -> a + ", " + b);
    }
    public static long countContainingChar(List<String> input, char ch){
        return input.stream().filter(s -> s.contains(String.valueOf(ch))).count();
    }

    public static int sumOfList(List<Integer> input){
        return input.stream().reduce(0, Integer::sum);
    }
    public static List<Integer> getSquares(List<Integer> input){
        return input.stream().map(el -> el * el).toList();
    }
    public static List<Integer> filterGreaterThan(List<Integer> input, int minValue){
        return input.stream().filter(el -> el > minValue).toList();
    }
    public static boolean containsNumber(List<Integer> input, int number){
        return input.stream().anyMatch(el -> el == number);
    }
    public static Optional<Integer> findMax(List<Integer> input){
        return input.stream().max(Integer::compareTo);
    }

    public static List<String> convertToStringList(List<Character> input){
        return input.stream().map(String::valueOf).toList();
    }
    public static List<Character> filterByAsciiValue(List<Character> input, int ascii){
        return input.stream().filter(el -> el >= ascii).toList();
    }
    public static boolean areAllUpperCase(List<Character> input){
        return input.stream().allMatch(Character::isUpperCase);
    }
    public static Optional<Character> findFirstDuplicate(List<Character> input){
        return input.stream().filter(el -> input.indexOf(el) != input.lastIndexOf(el)).limit(1).findFirst();
    }
    public static List<Character> reverseList(List<Character> input){
        return input.stream().sorted(Comparator.reverseOrder()).toList();
    }

    public static Optional<Float> findMin(List<Float> input){
        return input.stream().min(Float::compareTo);
    }
    public static List<Float> multiplyBy(List<Float> input, float multiplier){
        return input.stream().map(el -> el * multiplier).toList();
    }
    public static List<Float> filterLessThan(List<Float> input, float value){
        return input.stream().filter(el -> el < value).toList();
    }
    public static boolean containsNegative(List<Float> input){
        return input.stream().anyMatch(el -> el < 0);
    }
    public static List<Integer> roundNumbers(List<Float> input){
        return input.stream().map(Math::round).toList();
    }

    public static <T> long countUnique(List<T> input){
        return input.stream().distinct().count();
    }
    public static <T extends Comparable<T>> boolean isSorted(List<T> input){
        return IntStream.range(0, input.size() - 1)
                .allMatch(s -> input.get(s).compareTo(input.get(s + 1)) <= 0);
    }
     public static <T> Optional<T> getLastElement(List<T> input){
        return input.stream().reduce((a, b) -> b);
     }
     public static <T> List<T> shuffleList(List<T> input){
         return input.stream()
                 .collect(Collectors.collectingAndThen(
                         Collectors.toList(),
                         list -> {
                             Collections.shuffle(list);
                             return list;
                         }
                 ));
     }
     public static <T> Map<T, Long> countFrequency(List<T> input){
        return input.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
     }
}