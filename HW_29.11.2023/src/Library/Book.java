package Library;
import java.time.LocalDate;

    public class Book  extends LibraryItem implements Borrowable, Maintainable {
    BookStatus status;
    LocalDate publishDate;
    int pageCount;

        public Book(String title, String author, Genre genre, BookStatus status, LocalDate publishDate, int pageCount) {
            super(title, author, genre);
            this.status = status;
            this.publishDate = publishDate;
            this.pageCount = pageCount;
        }

        public BookStatus getStatus() {
            return status;
        }

        public LocalDate getPublishDate() {
            return publishDate;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setStatus(BookStatus status) {
            this.status = status;
        }

        @Override
        public void borrowItem(User user) {
            // Implementation
        }

        @Override
        public void returnItem(User user) {
            // Implementation
        }

        @Override
        public boolean isAvailable() {
            // Implementation
            return false;
        }

        @Override
        public void repairItem() {
            // Implementation
        }

        @Override
        public void updateItemCondition(ItemCondition condition) {
            // Implementation
        }

        @Override
        public ItemCondition checkCondition() {
            // Implementation
            return null;
        }

    }


