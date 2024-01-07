package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("ключ1", "Анна");
        map.put("ключ2", "Егор");
        map.put("ключ3", "Валерия");
        printMap(map);
        System.out.println();

        Map<String, String> mapValue = new HashMap<>();
        mapValue.put("ключ1", "диван");
        mapValue.put("ключ2", "стол");
        mapValue.put("ключ3", "стулья");
        mapValue.put("ключ4", "кресло");

        String string = "кресло";

        Set<String> keys = findKeysByValue(mapValue, string);
        System.out.println("Строка " + string + " равна " + keys);
        System.out.println();

        Map<String, String> stringMap1 = new HashMap<>();
        stringMap1.put("key1", "Natalia");
        stringMap1.put("key2", "Violetta");
        stringMap1.put("key3", "Marina");

        Map<String, String> stringMap2 = new HashMap<>();
        stringMap2.put("key3", "Anastasia");
        stringMap2.put("key5", "Marina");
        stringMap2.put("key6", "Sandra");

        Map<String, String> merged = mergeMapsIfUniqueKeys(stringMap1, stringMap2);
        System.out.println(merged);
        System.out.println();

        Map<String, String> mapOriginal = new HashMap<>();
        mapOriginal.put("key1", "table");
        mapOriginal.put("key2", "chair");
        mapOriginal.put("key3", "door");

        Map<String, String> mapNew = invertMap(mapOriginal);
        System.out.println(mapNew);
        System.out.println();

        Map<String, String> value = new HashMap<>();
        value.put("key1", "value2");
        value.put("key2", "value2");
        value.put("key3", "value2");

        int unique = countUniqueValues(value);
        System.out.println(unique);
        System.out.println();

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Анастасия");
        map1.put(2, "Екатерина");

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(3, "Владислав");
        map2.put(4, "Андрей");

        Set<Map<Integer, String>> mapALL = new HashSet<>();
        mapALL.add(map1);
        mapALL.add(map2);

        Set<String> values = findAllValues(mapALL);
        System.out.println(values);
        System.out.println();

        int sum = sumAllKeys(mapALL);
        System.out.println(sum);
        System.out.println();

        String value1 = "Галина";
        Set.of(map1, map2);
        boolean result = containsValue(mapALL, value1);
        if (result) {
            System.out.println("Присутствует в карте: " + value1);
        } else {
            System.out.println("Отсутствует в карте: " + value1);
        }
        System.out.println();

        Map<Character, Set<String>> char1 = new HashMap<>();
        char1.put('a', new HashSet<>(Arrays.asList("dskjfs", "jsdhsjk", "yhshhx")));
        char1.put('b', new HashSet<>(Arrays.asList("akfhcn", "rydjd", "rdhdhxj")));
        char1.put('c', new HashSet<>(Arrays.asList("fgdhsj", "dgcjdk", "trhwl")));

        Map<Character, Set<String>> char2 = new HashMap<>();
        char2.put('d', new HashSet<>(Arrays.asList("qskx", "jfkslk", "yhshhx")));
        char2.put('f', new HashSet<>(Arrays.asList("qpsl", "alkr", "rdhdhxj")));
        char2.put('g', new HashSet<>(Arrays.asList("ldkxsj", "truwj", "trhwl")));

        char symbol = 'd';

        Set<Map<Character, Set<String>>> combined = new HashSet<>();
        combined.add(char1);
        combined.add(char2);

        Set<String> resultChar = findAllStringsWithChar(combined, symbol);
        System.out.println("Строки, которые начинаются с символа " + symbol + ":");
        System.out.println(resultChar);
        System.out.println();

        Set<Map<Character, Set<String>>> complex = new HashSet<>();
        complex.add(char1);
        complex.add(char2);

        Map<Character, Integer> changeString = countStringOccurrences(complex);
        System.out.println(changeString);
    }

    public static void printMap(Map<String, String> map) {

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Ключ: " + key + ", Значение: " + value);
        }

    }

    public static Set<String> findKeysByValue(Map<String, String> map, String string) {
        Set<String> keys = new HashSet<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(string)) {
                keys.add(entry.getKey());
            }
        }

        return keys;
    }

    public static Map<String, String> mergeMapsIfUniqueKeys(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String> mergeMap = new HashMap<>(map1);

        for (Map.Entry<String, String> entry : map2.entrySet()) {
            if (!mergeMap.containsKey(entry.getKey())) {
                mergeMap.put(entry.getKey(), entry.getValue());
            }
        }

        return mergeMap;
    }


    public static Map<String, String> invertMap(Map<String, String> map) {
        Map<String, String> invertMap = new HashMap<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            invertMap.put(entry.getValue(), entry.getKey());
        }

        return invertMap;
    }

    public static int countUniqueValues(Map<String, String> map) {
        Set<String> count = new HashSet<>(map.values());
        return count.size();
    }

    public static Set<String> findAllValues(Set<Map<Integer, String>> setOfMaps) {
        Set<String> find = new HashSet<>();

        for (Map<Integer, String> map : setOfMaps) {
            find.addAll(map.values());
        }

        return find;
    }

    public static int sumAllKeys(Set<Map<Integer, String>> setOfMaps) {
        int sum = 0;

        for (Map<Integer, String> map : setOfMaps) {
            for (int key : map.keySet()) {
                sum += key;
            }
        }

        return sum;
    }

    public static boolean containsValue(Set<Map<Integer, String>> setOfMaps, String value) {
        for (Map<Integer, String> map : setOfMaps) {
            for (String value1 : map.values()) {
                if (value.equals(value1)) {
                    return true;
                }
            }
        }

        return false;
    }


    public static Set<String> findAllStringsWithChar(Set<Map<Character, Set<String>>> complexSet, char c) {
        Set<String> conclusion = new HashSet<>();

        for (Map<Character, Set<String>> map : complexSet) {
            for (Set<String> entry : map.values()) {
                for (String str : entry) {
                    if (str.startsWith(String.valueOf(c))) {
                        conclusion.add(str);
                    }
                }
            }
        }

        return conclusion;
    }

    public static Map<Character, Integer> countStringOccurrences(Set<Map<Character, Set<String>>> complexSet) {
        Map<Character, Integer> count = new HashMap<>();

        for (Map<Character, Set<String>> map : complexSet) {
            for (Set<String> entry : map.values()) {
                for (String str : entry) {
                    if (!str.isEmpty()) {
                        char nextChar = str.charAt(0);
                        count.merge(nextChar, 1, Integer::sum);
                    }
                }
            }
        }

        return count;
    }
}
