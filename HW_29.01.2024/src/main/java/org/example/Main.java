package org.example;

import javax.swing.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
//        createFile();
//        copyFileUsingFileStreams();

//        findTxtFilesInDirectory();
        copyLastParagraphUsingRandomAccess();

    }
    /**
     * Написать метод, который создает файл с именем
     * "example.txt" в текущей директории, затем считывает
     * этот файл с использованием FileInputStream и записывает
     * его содержимое в новый файл "copy_example.txt" с использованием FileOutputStream.
     *
     */
    public static void createFile() throws IOException {
        File file = new File("example.txt");
        try {
            boolean created = file.createNewFile();
            if (created) {
                System.out.println("File created");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyFileUsingFileStreams() throws IOException {
        try (FileInputStream inputStream = new FileInputStream("example.txt");
             FileOutputStream outputStream = new FileOutputStream("copy_example.txt")) {
            int b;

            while ((b = inputStream.read()) != -1) {
                outputStream.write(b);
            }
            System.out.println("!!!DONE!!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Написать метод, который использует Path и Files
     * для копирования файла "example.txt" в новый файл "copy_example_path.txt".
     * Проверить, существует ли файл "example.txt" перед копированием.
     */
    public static void copyFileUsingPath() throws IOException {
        try {
            Path file = Paths.get("example.txt");
            Path copyFile = Paths.get("copy_example_path.txt");
            if (Files.exists(file)) {
                Files.copy(file, copyFile);
            } else {
                System.out.println("File not found");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Написать метод, который открывает файл "example.txt"
     * с использованием RandomAccessFile, читает первые 20 байт и записывает
     * их в новый файл "random_access_copy.txt".
     */
    public static void copyFileUsingRandomAccessFile() throws IOException {
        try {
            RandomAccessFile file = new RandomAccessFile("example.txt", "r");
            RandomAccessFile copyFile = new RandomAccessFile("random_access_copy.txt", "rw");
            byte[] bytes = new byte[20];
            file.read(bytes);
            copyFile.write(bytes);
            file.close();
            copyFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Написать метод, который читает файл "example.txt",
     * подсчитывает количество слов в файле и записывает это количество
     * в новый файл "word_count.txt". Использовать BufferedReader и BufferedWriter
     * для эффективной работы с текстом.
     */
    public static void countWordsInFile() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("word_count.txt"));

            String line;
            int wordCount = 0;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                wordCount += words.length;
            }

            writer.write(String.valueOf(wordCount));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Написать метод с использованием класса Path, который ищет все файлы с расширением ".txt"
     * в текущей директории и её поддиректориях. Результаты поиска
     * (пути к файлам) записать в файл "found_files.txt".
     */
    public static void findTxtFilesInDirectory() throws IOException {
        Path directory = Paths.get(".");
        Path foundFiles = Paths.get("found_files.txt");

        try {
            Files.write(foundFiles, Files.walk(directory)
                    .map(Path::toString)
                    .filter(string -> string.endsWith(".txt"))
                    .toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Написать метод, который открывает файл "example.txt"
     * с использованием RandomAccessFile, переходит к последнему абзацу
     * в файле и копирует его содержимое в новый файл "last_paragraph.txt".
     */
    public static void copyLastParagraphUsingRandomAccess() throws IOException {
        try {
            RandomAccessFile file = new RandomAccessFile("example.txt", "r");
            RandomAccessFile copyFile = new RandomAccessFile("last_paragraph.txt", "rw");

            file.seek(file.length() - 1);

            while (file.getFilePointer() > 0) {
                file.seek(file.getFilePointer() - 2);
                char currentChar = (char) file.readByte();
                if (currentChar == '\n') {
                    break;
                }
            }

            byte[] lastParagraph = new byte[(int) (file.length() - file.getFilePointer())];
            file.readFully(lastParagraph);

            copyFile.write(lastParagraph);

            file.close();
            copyFile.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
