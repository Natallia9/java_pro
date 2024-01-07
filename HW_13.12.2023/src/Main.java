import java.util.*;

public class Main {
    public static void main(String[] args) {

        String org = "Natalia";
        String orgNew = reverse(org);
        System.out.println(orgNew);
        System.out.println();

        Queue<String> queue = new LinkedList<>();
        queue.offer("str");
        queue.offer("ghk");
        queue.offer("qeu");
        queue.offer("kjl");
        queue.offer("asd");

        printInReverse(queue);
        System.out.println();

        rotate(queue, 3);
        System.out.println(queue);
        System.out.println();

        Map<String, String> map = new HashMap<>();
        map.put("1", "Value1");
        map.put("2", "Value2");
        map.put("3", "Value3");

        Map<String, String> invertMap = invert(map);
        System.out.println(invertMap);
        System.out.println();

        int number = 60;
        Map<Integer, Integer> result = primeFactorization(number);

        System.out.println("Факториал числа " + number + ":");
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + "^" + entry.getValue());
        }
        System.out.println();

        String str1 = "актер";
        String str2 = "терка";

        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " и " + str2 + " анаграммы.");
        } else {
            System.out.println(str1 + " и " + str2 + " не являются анаграммами.");
        }
    }

    public static String reverse(String str) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(String.valueOf(str.charAt(i)));
        }
        StringBuilder stringReversed = new StringBuilder();
        while (!stack.isEmpty()) {
            stringReversed.append(stack.pop());
        }
        return stringReversed.toString();
    }

    public static void printInReverse(Queue<String> queue) {
        Stack<String> reverse = new Stack<>();

        for (String item : queue) {
            reverse.push(item);
        }
        while (!reverse.isEmpty()) {
            System.out.println(reverse.pop());
        }
    }

    public static void rotate(Queue<String> queue, int k) {
        if (k > queue.size()) {
            k = k % queue.size();
        }

        for (int i = 0; i < k; i++) {
            String temp = queue.remove();
            queue.add(temp);
        }
    }

    public static Map<String, String> invert(Map<String, String> map) {
        Map<String, String> invert = new LinkedHashMap<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            invert.put(entry.getValue(), entry.getKey());
        }
        return invert;
    }

    public static Map<Integer, Integer> primeFactorization(int num) {
        Map<Integer, Integer> factorial = new HashMap<>();

        for (int i = 2; i <= num; i++) {
            int count = 0;

            while (num % i == 0) {
                num /= i;
                count++;
            }

            if (count > 0) {
                factorial.put(i, count);
            }
        }
        return factorial;
    }

    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            if (map.containsKey(char1)) {
                map.put(char1, map.get(char1) + 1);
            } else {
                map.put(char1, 1);
            }

            if (map.containsKey(char2)) {
                map.put(char2, map.get(char2) - 1);
            } else {
                map.put(char2, -1);
            }
        }

        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
//        for (int i = 0; i < str1.length(); i++) {
//            if (map.containsKey(str1.charAt(i))) {
//                map.put(str1.charAt(i),
//                        map.get(str1.charAt(i)) + 1);
//            }
//            else {
//                map.put(str1.charAt(i), 1);
//            }
//        }
//        for (int i = 0; i < str2.length(); i++) {
//            if (map.containsKey(str2.charAt(i))) {
//                map.put(str2.charAt(i),
//                        map.get(str2.charAt(i)) - 1);
//            }
//        }
//        Set<Character> keys = map.keySet();
//
//        for (Character key : keys) {
//            if (map.get(key) != 0) {
//                return false;
//            }
//        }
//        return true;
//    }


