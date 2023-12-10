package Library;
import java.util.List;
public class LibraryCatalogue implements Searchable {
    List<Book> books;
    List<Magazine> magazines;

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
