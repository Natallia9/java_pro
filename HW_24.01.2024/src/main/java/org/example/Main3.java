package org.example;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {
        List<Book> books;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("books.txt"));
             ObjectOutputStream outputStream = new ObjectOutputStream(
                     new FileOutputStream("authorAveragePrice.ser"))) {
            books = (List<Book>) inputStream.readObject();
            Map<String, Map<String, Double>> authorAveragePrice = books.stream()
                    .collect(Collectors.groupingBy(Book::getAuthor,
                            Collectors.groupingBy(Book::getTitle, Collectors.averagingDouble(Book::getPrice))));

            outputStream.writeObject(authorAveragePrice);
            System.out.println(authorAveragePrice);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
