public class Main {
    public static void main(String[] args) {

        Book book = new Book("Звездная пыль", "Нил Гейман", 1998);
        System.out.println(book.information());
        book.oldBook();

        System.out.println();

        Reader reader = new Reader("Владимир", 23, new String[]{"Книга1", "Книга2", "Книга3"});
        reader.talkingBooks("Книга1");
        reader.returnBooks("Книга2");

        System.out.println();

        Librarian librarian = new Librarian("Татьяна", 5, new String[]{"Книга5", "Книга6", "Книга7"});
        librarian.issueBooks("Книга6");
        librarian.getBook("Книга7");

        System.out.println();

        Library library = new Library("Городская библиотека", "Замковая 5", new String[]{"Мария", "Оксана", "Виолетта"});
        library.addLibrarian("Наталья");
        library.addLibrarian("Виктория");

        String nameSearch = "Виктория";
        String found = library.search(nameSearch);
        if (found != null) {
            System.out.println("Имя " + nameSearch + " есть в списке");
        } else {
            System.out.println("Данного имени нет в списке");
        }

    }
}
