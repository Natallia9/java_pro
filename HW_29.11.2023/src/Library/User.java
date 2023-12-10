package Library;

import java.util.List;

public class User implements Searchable {
    String name;
    String id;
    List<LibraryItem> borrowedItems;

    public User(String name, String id, List<LibraryItem> borrowedItems) {
        this.name = name;
        this.id = id;
        this.borrowedItems = borrowedItems;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
    }
    @Override
    public List<LibraryItem> findByTitle(String title) {
        // Implementation
        return null;
    }

    @Override
    public List<LibraryItem> findByAuthor(String author) {
        // Implementation
        return null;
    }

    @Override
    public List<LibraryItem> findByGenre(Genre genre) {
        // Implementation
        return null;
    }
}

