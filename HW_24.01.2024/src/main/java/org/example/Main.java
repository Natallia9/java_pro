package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book(1, "Война и мир", "Лев Толстой", 1869, 500),
                new Book(2, "1984", "Джордж Оруэлл", 1949, 300),
                new Book(3, "Улисс", "Джеймс Джойс", 1922, 450),
                new Book(4, "Властелин колец", "Дж. Р. Р. Толкиен", 1954, 600),
                new Book(5, "Гордость и предубеждение", "Джейн Остен", 1813, 350)
        );

        books.forEach(System.out::println);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("books.txt"))) {

            outputStream.writeObject(books);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}