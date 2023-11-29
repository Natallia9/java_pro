public class Librarian {
    private String name;
    private int workExperience;
    private String[] listBooks;

    public Librarian(String name, int workExperience, String[] listBooks) {
        this.name = name;
        this.workExperience = workExperience;
        this.listBooks = listBooks;
    }

    public String getName() {
        return name;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public String[] getListBooks() {
        return listBooks;
    }

    public void issueBooks(String titleBook) {
        for (int i = 0; i < listBooks.length; i++) {
            if (listBooks[i] != null && listBooks[i].equals(titleBook)) {
                System.out.println("Книга выдана: " + titleBook);
                listBooks[i] = null;
                return;
            }
        }
    }

    public void getBook(String titleBook) {
        for (int i = 0; i < listBooks.length; i++) {
            if (listBooks[i] == null) {
                listBooks[i] = titleBook;
                System.out.println("Книга возвращена читателем: " + titleBook);
                return;
            }
        }
    }

}



