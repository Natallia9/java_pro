import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> people = new HashMap<>();
        people.put("Анна", 25);
        people.put("Борис", 30);
        people.put("Виктор", 35);

        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            entry.setValue(entry.getValue() * 2);
            System.out.println("Удвоенный возраст");
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Map<Integer, String> users = new HashMap<>();
        users.put(101, "Анна");
        users.put(97, "Борис");
        users.put(103, "Виктор");
        users.put(34, "Галина");
        users.put(105, "Дмитрий");

        Map<Integer, String> filteredUsers = new TreeMap<>();
        for (Map.Entry<Integer, String> entry : users.entrySet()) {
            if (entry.getKey() > 100) {
                filteredUsers.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<Integer, String> entry1 : filteredUsers.entrySet()) {
            System.out.println("Пользователи с ID больше 100: " + entry1.getKey() + ", Имя: " + entry1.getValue());
        }

        Map<User, String> userMap = new TreeMap<>();
        userMap.put(new User("Анна", 25), "Дизайнер");
        userMap.put(new User("Борис", 30), "Разработчик");
        userMap.put(new User("Виктор", 35), "Менеджер");

        for (User user : userMap.keySet()) {
            System.out.println("Имя - " + user.getName() + " : " + "Возраст - " + user.getAge());
        }

        TreeMap<User, String> treeMap = new TreeMap<>(new User.UserNameComparator());
        treeMap.put(new User("Анна", 25), "Data1");
        treeMap.put(new User("Борис", 30), "Data2");
        treeMap.put(new User("Виктор", 28), "Data3");

        for (User user : treeMap.keySet()) {
            System.out.println(user.getName() + ": " + treeMap.get(user));
        }

        Map<String, User> map1 = new HashMap<>();
        map1.put("Анна", new User("Анна", 25));
        map1.put("Борис", new User("Борис", 30));

        Map<String, User> map2 = new HashMap<>();
        map2.put("Виктор", new User("Виктор", 35));
        map2.put("Анна", new User("Анна", 25));

        Map<String, User> combinedMap = new HashMap<>(map1);
        for (Map.Entry<String, User> entry : map2.entrySet()) {
            if (!combinedMap.containsKey(entry.getKey())) {
                combinedMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, User> entry : combinedMap.entrySet()) {
            System.out.println(entry);
        }

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Один");
        hashMap.put(2, "Два");
        hashMap.put(3, "Три");

        TreeMap<String, Integer> treeMap1 = new TreeMap<>();

        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            treeMap1.put(entry.getValue(), entry.getKey());
        }

        for (Map.Entry<String, Integer> entry1 : treeMap1.entrySet()) {
            System.out.println(entry1.getKey() + ": " + entry1.getValue());
        }

        HashMap<String, Integer> hashMap1 = new HashMap<>();
        hashMap1.put("Один", 1);
        hashMap1.put("Два", 2);
        hashMap1.put("Три", 3);
        hashMap1.put("Четыре", 4);

        List<Integer> valuesList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : hashMap1.entrySet()) {
            valuesList.add(entry.getValue());
        }

        for (Integer value : valuesList) {
            System.out.println(value);
        }
        TreeMap<String, Integer> treeMap2 = new TreeMap<>();
        treeMap2.put("Один", 30);
        treeMap2.put("Два", 55);
        treeMap2.put("Три", 40);
        treeMap2.put("Четыре", 60);
        treeMap2.put("Пять", 20);

        HashMap<Integer, String> filteredMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : treeMap2.entrySet()) {
            if (entry.getValue() > 50) {
                filteredMap.put(entry.getValue(), entry.getKey());
            }
        }

        System.out.println("HashMap<Integer, String> с значениями > 50:");
        for (Map.Entry<Integer, String> entry : filteredMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        HashMap<String, List<Integer>> studentScores = new HashMap<>();
        studentScores.put("Анна", Arrays.asList(80, 90, 85));
        studentScores.put("Борис", Arrays.asList(70, 75, 72));
        studentScores.put("Виктор", Arrays.asList(90, 95, 92));
        studentScores.put("Галина", Arrays.asList(85, 88, 90));

        TreeMap<Integer, List<String>> averageScoreMap = new TreeMap<>();

        for (Map.Entry<String, List<Integer>> entry : studentScores.entrySet()) {
            String studentName = entry.getKey();
            List<Integer> scores = entry.getValue();

            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            int averageScore = sum / scores.size();

            averageScoreMap.computeIfAbsent(averageScore, k -> new ArrayList<>()).add(studentName);
        }

        System.out.println("Средняя оценка - список студентов:");
        for (Map.Entry<Integer, List<String>> entry : averageScoreMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

