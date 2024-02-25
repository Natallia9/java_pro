package org.example;


import java.io.*;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        averageRating("C:\\java pro\\HW_22.01.2024\\src\\main\\java\\org\\example\\f.txt", "new_File.txt");
//        lowRating("C:\\java pro\\HW_22.01.2024\\src\\main\\java\\org\\example\\f.txt", "new_File.txt");
//        prefix("C:\\java pro\\HW_22.01.2024\\src\\main\\java\\org\\example\\f.txt", "new_File.txt");
//        longString("C:\\java pro\\HW_22.01.2024\\src\\main\\java\\org\\example\\f.txt", "new_File.txt");
        summary("C:\\java pro\\HW_22.01.2024\\src\\main\\java\\org\\example\\f.txt", "new_File.txt");

    }

    //  Прочитайте файл и посчитайте средний рейтинг всех стримов. Запишите результат в новый файл
    public static void averageRating(String fileName, String str) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(str))) {
            OptionalDouble average = reader.lines()
                    .map(el -> el.split(", ")[1])
                    .mapToDouble(Double::parseDouble)
                    .average();
            average.ifPresent(avg -> {
                try {
                    writer.write(String.valueOf(avg));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Отфильтруйте стримы, имеющие рейтинг выше 4.5, и запишите их в новый файл
    public static void filter(String fileName, String str) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(str))) {
            reader.lines()
                    .filter(el -> Double.parseDouble(el.split(", ")[1]) > 4.5)
                    .forEach(el -> {
                        try {
                            writer.write(el);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Файл записан");

    }

    //    Сгруппируйте стримы по названию и запишите количество стримов в каждой группе в новый файл
    public static void group(String fileName, String str) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(str))) {
            reader.lines()
                    .map(el -> el.split(", ")[0])
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .forEach((key, value) -> {
                        try {
                            writer.write(key + " " + value);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Отсортируйте стримы по рейтингу от наибольшего к наименьшему и запишите результаты в новый файл
    public static void sort(String fileName, String str) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(str))) {
            reader.lines()
                    .map(el -> el.split(", ")[1])
                    .sorted((el1, el2) -> Double.compare(Double.parseDouble(el2), Double.parseDouble(el1)))
                    .forEach(el -> {
                        try {
                            writer.write(el);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Найдите стримы с минимальным рейтингом и выведите их в новый файл
    public static void min(String fileName, String str) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(str))) {
            reader.lines()
                    .map(el -> el.split(", ")[1])
                    .min(Comparator.comparing(Double::parseDouble))
                    .ifPresent(el -> {
                        try {
                            writer.write(el);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Соберите статистику по рейтингам (минимальный, максимальный, средний) и запишите ее в новый файл
    public static void statistic(String fileName, String str) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(str))) {
            DoubleSummaryStatistics stat = reader.lines()
                    .map(el -> el.split(", ")[1])
                    .mapToDouble(Double::parseDouble)
                    .summaryStatistics();

            writer.write("Минимальный рейтинг: " + stat.getMin() + "\n");
            writer.write("Максимальный рейтинг: " + stat.getMax() + "\n");
            writer.write("Средний рейтинг: " + stat.getAverage() + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    Измените названия всех стримов, добавив к ним префикс "Stream-" и запишите обновленные названия в новый файл
    public static void prefix(String fileName, String str) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(str))) {
            reader.lines()
                    .map(el -> {
                        String[] strings = el.split(": |, ");
                        if (strings.length >= 3) {
                            String id = strings[0];
                            String name = strings[1];
                            String[] nameParts = name.split(" ");
                            if (nameParts.length >= 2) {
                                String nameNew = "Stream-" + nameParts[1];
                                return id + ": [" + nameNew + ", " + strings[2];
                            }
                        }
                        return el;
                    })
                    .forEach(line -> {
                        try {
                            writer.write(line);
                            writer.newLine();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Отфильтруйте стримы с рейтингом ниже 4.7 и преобразуйте их названия, добавив в конец "- Low Rated". Запишите результаты в новый файл
    public static void lowRating(String fileName, String str) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(str))) {
            reader.lines()
                    .filter(el -> Double.parseDouble(el.split(", ")[1]) < 4.7)
                    .map(s -> s + " - Low Rated")
                    .forEach(el -> {
                        try {
                            writer.write(el);
                            writer.newLine();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Соберите все названия стримов в одну длинную строку, разделяя их запятыми, и запишите эту строку в новый файл
    public static void longString(String fileName, String str) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(str))) {
            reader.lines()
                    .map(el -> {
                        String[] strings = el.split(": |, ");
                        if (strings.length >= 3) {
                            return strings[1].replaceAll("[\\[\\]]", "") + ", ";
                        }
                        return el;
                    })
                    .forEach(el -> {
                        try {
                            writer.write(el);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    Создайте сводку, включающую идентификатор стрима, название и рейтинг,
//    и запишите ее в новый файл в формате "ID: Название - Рейтинг"
    public static void summary(String fileName, String str) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(str))) {
            reader.lines()
                    .map(el -> {
                        String[] strings = el.split(": |, ");
                        if (strings.length >= 3) {
                            return strings[0] + ": " + strings[1] + " - " + strings[2];
                        }
                        return el;
                    })
                    .forEach(el -> {
                        try {
                            writer.write(el);
                            writer.newLine();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Файл записан");
        System.out.println("Создана сводка");
    }

}








