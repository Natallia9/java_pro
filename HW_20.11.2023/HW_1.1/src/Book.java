public class Book {
    private String title;
    private String author;
    private int yearOfPublication;

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public String information() {
        return "Информация о книге\n" +
                "Название: " + title + '\n' +
                "Автор: " + author + '\n' +
                "Год издания: " + yearOfPublication;
    }

    public void oldBook() {

        int thisYear = 2023;
        int age = thisYear - yearOfPublication;
        if (age > 50) {
            System.out.println("Книга старинная");
        } else {
            System.out.println("Книге менее 50 лет");
        }
    }
}