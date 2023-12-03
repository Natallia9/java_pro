import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // Задание 1

        // Дан массив/коллекция целых чисел и целое число X.
        // Найти пару чисел в массиве/коллекции, сумма которых равна X.

        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(2);
        list.add(8);
        list.add(34);
        list.add(7);
        list.add(76);
        list.add(13);
        list.add(45);
        list.add(54);
        list.add(15);
        System.out.println(list);

        int num = 32;
        int size = list.size();
        boolean pair = false;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((list.get(i) + list.get(j)) == num) {
                    System.out.println("Пара чисел " + list.get(i) + " и " + list.get(j) + " = " + num);
                    pair = true;
                    break;
                }
            }
        }
        if (!pair) {
            System.out.println("Пара чисел не найдена");
        }

        System.out.println();
        // Дан массив/коллекция целых чисел.
        // Необходимо подсчитать, сколько раз каждый элемент встречается в массив/коллекции.

        List<Integer> list2 = new ArrayList<>();
        list2.add(12);
        list2.add(2);
        list2.add(12);
        list2.add(34);
        list2.add(7);
        list2.add(75);
        list2.add(13);
        list2.add(45);
        list2.add(75);
        list2.add(75);
        System.out.println(list2);

        for (int i = 0; i < list2.size(); i++) {
            int num2 = list2.get(i);
            int once = 1;
            for (int j = i + 1; j < list2.size(); j++) {
                if (num2 == list2.get(j)) {
                    once++;
                    list2.remove(j);
                    j--;
                }
            }
            System.out.println("Число " + num2 + " встречается " + once + " раз(а)");
        }
        System.out.println();
        //  Дан массив/коллекция. Удалить все дубликаты из массива/коллекции

        List<Integer> list3 = new ArrayList<>();
        list3.add(12);
        list3.add(2);
        list3.add(12);
        list3.add(34);
        list3.add(7);
        list3.add(75);
        list3.add(13);
        list3.add(45);
        list3.add(75);
        list3.add(75);

        for (int i = 0; i < list3.size(); i++) {
            for (int j = i + 1; j < list3.size(); j++) {
                if ((list3.get(i).equals(list3.get(j)))) {
                    list3.remove(j);
                    j--;
                }
            }
        }
        System.out.println("Массив без повторяющихся элементов " + list3);

        System.out.println();
        // Дан массив/коллекция целых чисел.
        // Необходимо переставить элементы массив/коллекции в обратном порядке.

        List<Integer> list4 = new ArrayList<>();
        list4.add(12);
        list4.add(2);
        list4.add(12);
        list4.add(34);
        list4.add(7);
        list4.add(75);
        list4.add(13);
        list4.add(45);
        list4.add(83);
        list4.add(27);
        System.out.println(list4);
        for (int i = list4.size() - 1; i >= 0; i--) {
            System.out.print(list4.get(i) + ", ");
        }
        System.out.println();
        System.out.println();

        // Задание 2
        // Реализовать метод, который удаляет все вхождения заданной строки из List<String>
        List<String> string = new ArrayList<>();
        string.add("cat");
        string.add("dog");
        string.add("bird");
        string.add("bird");

        newList(string);
        System.out.println(string);
        System.out.println();

        // Составить метод, который объединяет все строки из List в одну большую строку.
        List<String> string2 = new ArrayList<>();
        string2.add("cat");
        string2.add("dog");
        string2.add("bird");
        string2.add("hamster");

        String unite = concatenated(string2);
        System.out.println(unite);
        System.out.println();

        // Дан List 1,написать метод который создает List 2,
        // содержащий только те числа из List 1, которые больше заданного значения
        List<Integer> list5 = new ArrayList<>();
        list5.add(12);
        list5.add(2);
        list5.add(12);
        list5.add(34);
        list5.add(7);
        list5.add(75);
        list5.add(13);
        list5.add(45);
        list5.add(83);
        list5.add(27);
        System.out.println(list5);

        int num5 = 30;

        List<Integer> list6 = sortNumbers(list5, num5);
        System.out.println(list6);
        System.out.println();

        // Написать метод, который преобразует List<String> в List<Integer>,
        // представляющих длину каждой строки
        List<String> string3 = new ArrayList<>();
        string3.add("cat");
        string3.add("dog");
        string3.add("bird");
        string3.add("hamster");
        System.out.println(string3);

        List<Integer> integer = transformation(string3);
        System.out.println(integer);
        System.out.println();

        // Разработать метод, который возвращает новый List,
        // содержащий только уникальные элементы из исходного списка строк
        List<String> string4 = new ArrayList<>();
        string4.add("cat");
        string4.add("dog");
        string4.add("bird");
        string4.add("hamster");
        string4.add("hamster");

        System.out.println(string4);

        List<String> uniqueElements = elements(string4);
        System.out.println(uniqueElements);
    }

    private static void newList(List<String> strings) {
        List<String> result = new ArrayList<>();
        for (String s : strings) {
            if (!s.equals("bird")) {
                result.add(s);
            }
        }
        strings.clear();
        strings.addAll(result);
    }

    private static String concatenated(List<String> strings) {
        StringBuilder newString = new StringBuilder();
        for (String string : strings) {
            newString.append(string).append(" ");
        }
        return newString.toString();
    }

    private static List<Integer> sortNumbers(List<Integer> numbers, int border) {
        List<Integer> sort = new ArrayList<>();
        for (int n : numbers) {
            if (n > border) {
                sort.add(n);
            }
        }
        return sort;
    }

    private static List<Integer> transformation(List<String> strings) {
        List<Integer> integer = new ArrayList<>();

        for (String str : strings) {
            integer.add(str.length());
        }

        return integer;
    }

    private static List<String> elements(List<String> strings) {
        List<String> unique = new ArrayList<>();

        for (String element : strings) {
            if (!unique.contains(element)) {
                unique.add(element);
            }
        }

        return unique;
    }
}






















