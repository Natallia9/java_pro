import java.util.*;


public class Main {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("ключ1", "кот");
        map.put("ключ2", "собака");
        map.put("ключ3", "птица");
        map.put("ключ4", "хомяк");

        int quantity = 0;
        for (String key : map.keySet()) {
            String value = map.get(key);

            if (key.length() == value.length()) {
                quantity++;
            }
        }

        System.out.println("Количество пар, где длина ключа равна длине значения " + quantity);

        HashMap<String, Integer> key1 = new HashMap<>();
        key1.put("Ab", 12);
        key1.put("Cd", 78);
        key1.put("Af", 23);
        key1.put("Jk", 11);

        int sum = 0;
        for (String key2 : key1.keySet()) {
            if (key2.startsWith("A")) {
                sum += key1.get(key2);
            }
        }
        System.out.println("Cумму всех значений, соответствующих ключам, начинающимся на букву 'A' " + sum);

        HashMap<Integer, List<String>> hashMap = new HashMap<>() {{
            put(1, Arrays.asList("адресат", "оберег", "экватор"));
            put(2, Arrays.asList("аспект", "работа", "скатерть"));
            put(3, Arrays.asList("устав", "стул", "венок"));
        }};

        for (Integer s : hashMap.keySet()) {
            List<String> stringList = hashMap.get(s);
            System.out.println("Строки начинающиеся с гласной буквы " + s + ":");

            for (String str : stringList) {
                if (vowel(str)) {
                    System.out.println(str);
                }
            }
        }
        HashMap<Integer, Integer> n = new HashMap<>();
        n.put(1, 3);
        n.put(2, 6);
        n.put(3, 10);
        n.put(4, 5);

        Map.Entry<Integer, Integer> maxEntry = maxValue(n);
        System.out.println("Максимальная пара: Ключ = " + maxEntry.getKey() + ", Значение = " + maxEntry.getValue());
        System.out.println(n.entrySet());

        HashMap<String, String> str = new HashMap<>();
        str.put("abc", "cba");
        str.put("cat", "tac");
        str.put("dog", "godd");
        str.put("uiop", "uiop");

        reversePair(str);

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("Da", 6);
        map2.put("Cx", 8);
        map2.put("Lk", 10);
        map2.put("Hn", 3);

        HashMap<String, String> transformationMap = transformation(map2);
        System.out.println(transformationMap);

        Map<Integer, List<String>> map3 = new HashMap<>();
        map3.put(1, List.of("zxc", "vbn", "nmv"));
        map3.put(2, List.of("ert", "tyu", "sdf"));
        map3.put(3, List.of("qwert", "tyui", "hjk"));

        Map<Integer, Integer> secondMap3 = creationMap(map3);

        System.out.println(secondMap3);

        HashMap<Integer, Integer> map4 = new HashMap<>();
        map4.put(12, 3);
        map4.put(23, 10);
        map4.put(34, 134);
        map4.put(45, 46);
        map4.put(56, 67);

        calculation(map4);

        Map<String, String> map5 = new HashMap<>();
        map5.put("wjk", "ess");
        map5.put("kfjfn", "kfjc");
        map5.put("gfjd", "kdmms");
        map5.put("hdhjx", "jsks");

        List<String> list = converter(map5);
        System.out.println(list);


    }


    private static boolean vowel(String str) {
        String vowelLetter = str.toLowerCase();
        return vowelLetter.startsWith("а") || vowelLetter.startsWith("е")
                || vowelLetter.startsWith("и") || vowelLetter.startsWith("о") || vowelLetter.startsWith("у")
                || vowelLetter.startsWith("э") || vowelLetter.startsWith("ю") || vowelLetter.startsWith("я");
    }

    static Map.Entry<Integer, Integer> maxValue(Map<Integer, Integer> max) {
        int value = Integer.MIN_VALUE;
        int key = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : max.entrySet()) {
            if (entry.getValue() > value) {
                value = entry.getValue();
                key = entry.getKey();
            }
        }
        return new AbstractMap.SimpleEntry<>(key, value);
    }

    static void reversePair(Map<String, String> string) {
        for (Map.Entry<String, String> entry : string.entrySet()) {
            if (isReverse(entry.getKey(), entry.getValue())) {
                System.out.println("Найдена обратная пара: " + entry.getKey() + " - " + entry.getValue());
            }

        }
    }

    static boolean isReverse(String key, String value) {
        return new StringBuilder(value).reverse().toString().equals(key);
    }

    private static HashMap<String, String> transformation(HashMap<String, Integer> map) {
        HashMap<String, String> transformation = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            String stringValue = String.valueOf(value * 2);
            transformation.put(key, stringValue);
        }
        return transformation;
    }

    private static Map<Integer, Integer> creationMap(Map<Integer, List<String>> map) {
        Map<Integer, Integer> secondMap = new HashMap<>();

        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            int temp = meaning(entry.getValue());
            secondMap.put(entry.getKey(), temp);
        }

        return secondMap;
    }

    private static int meaning(List<String> strings) {
        int temp = 0;

        for (String str : strings) {
            temp += str.length();
        }

        return temp;
    }

    private static void calculation(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            int subtract = key - value;

            if (isSimple(subtract)) {
                System.out.println("Пара найдена: (" + key + ", " + value + ")");
            }
        }
    }

    public static boolean isSimple(Integer number) {
        if (number < 2) return false;
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<String> converter(Map<String, String> map) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String concatenated = entry.getKey() + entry.getValue();
            element(list, concatenated);
        }
        return list;
    }
    private static void element(List<String> list, String element) {
        if (!list.contains(element)) {
            list.add(element);
        }
    }
}






