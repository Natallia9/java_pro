package org.example;

import java.io.*;
import java.util.Comparator;
import java.util.List;

public class Main2 {
    public static void main(String[] args){

        List<Book> books;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("books.txt"));
             ObjectOutputStream outputStream = new ObjectOutputStream(
                     new FileOutputStream("books_price.ser"))) {
            books = (List<Book>) inputStream.readObject();


            List<Book> filteredBooks = books.stream()
                    .filter(b -> b.getPrice() >= 350)
                    .sorted(Comparator.comparingDouble(Book::getPrice))
                    .toList();


            outputStream.writeObject(filteredBooks);
            System.out.println(filteredBooks);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

