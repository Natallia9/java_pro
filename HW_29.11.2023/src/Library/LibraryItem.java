package Library;

import java.time.LocalDate;

public abstract class LibraryItem {
    private String title;
    private String author;
    private Genre genre;

    public LibraryItem(String title, String author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "Заголовок'" + title + '\'' +
                ", Автор'" + author + '\'' +
                ", Жанр" + genre +
                '}';
    }


    public abstract boolean isAvailable();


    public LocalDate getPublishDate() {
        return null;
    }

}