public class Reader {
    private String name;
    private int age;
    private String[] books;

    public Reader(String name, int age, String[] books) {
        this.name = name;
        this.age = age;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getBooks() {
        return books;
    }


    public void talkingBooks(String bookName) {

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].equals(bookName)) {
                System.out.println("Книга у читателя: " + bookName);
                books[i] = null;
                return;
            }
        }
    }

    public void returnBooks(String bookName) {

        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = bookName;
                System.out.println("Книга возвращена читателем: " + bookName);
                return;
            }
        }
    }
}

