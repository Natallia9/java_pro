package Library;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
public class CollectionProcessor {
    public static void printAllItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            System.out.println("Заголовок: " + item.getTitle() +
                    ", Автор: " + item.getAuthor() +
                    ", Жанр: " + item.getGenre());
        }

    }

   public static void listItemsByGenre(List<LibraryItem> items, Genre genre) {
        boolean search = false;

        for (LibraryItem item : items) {
            if (item.getGenre().equals(genre)) {
                if (!search) {
                    search = true;
                    System.out.println("Книги в жанре: " + genre);
                }
            }
        }

        if (!search) {
            System.out.println("Книга в жанре " + genre + " не найдена");
        }
    }

    public static void sortByTitle(List<LibraryItem> items) {
        items.sort(Comparator.comparing(libraryItem -> libraryItem.getTitle()));
        printAllItems(items);
    }
    public static void filterByAuthor(List<LibraryItem> items, String author) {
        List<LibraryItem> filtere = new ArrayList<>();

        for (LibraryItem item : items) {
            if (item instanceof Book book) {
                if (book.getAuthor().equals(author)) {
                    filtere.add(book);
                }
            }
        }
        System.out.println("Книги автора " + author + ":");
        printAllItems(filtere);
    }

    public static void countItemsByStatus(List<LibraryItem> items, BookStatus status) {
        int count = 0;

        for (LibraryItem item : items) {
            if (item instanceof Book book) {
                if (book.getStatus().equals(status)) {
                    count++;
                    System.out.println("Количество доступных книг: " + count);
                }
            }
        }
    }

    public static void updateStatus(List<LibraryItem> items, BookStatus oldStatus, BookStatus newStatus) {
        for (LibraryItem item : items) {
            if (item instanceof Book book) {
                if (book.getStatus().equals(oldStatus)) {
                    book.setStatus(newStatus);
                }
            }
        }
    }

   public static void listAvailableItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            if (item instanceof Borrowable borrowableItem) {
                if (borrowableItem.isAvailable()) {
                    System.out.println("Название: " + item.getTitle() + ", Автор: " + item.getAuthor() +
                            ", Статус: " + ((Borrowable) item).isAvailable());
                }
            }
        }
    }

    public static LibraryItem findOldestItem(List<LibraryItem> items) {
        LibraryItem oldest = items.get(0);

        for (LibraryItem item : items) {
            if (item instanceof Book book) {
                if (book.getPublishDate().isBefore(oldest.getPublishDate())) {
                    oldest = item;
                }
            }
        }

        return oldest;
    }

    public static void groupItemsByAuthor(List<LibraryItem> items) {
        List<String> authors = new ArrayList<>();

        for (LibraryItem item : items) {
            if (!authors.contains(item.getAuthor())) {
                authors.add(item.getAuthor());
            }
        }

        for (String author : authors) {
            System.out.print("Автор: " + author + " Книги: ");
            for (LibraryItem item : items) {
                if (author.equals(item.getAuthor())) {
                    System.out.print(item.getTitle() + " ");
                }
            }
        }
    }

    public static void listItemsForRepair(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            if (item instanceof Book book) {
                if (book.getStatus().equals(BookStatus.UNDER_REPAIR)) {
                    System.out.println("Заголовок: " + book.getTitle() + ", Автор: " + book.getAuthor());
                } else {
                    System.out.println("Книга " + book.getTitle() + " не требует ремонта.");
                }
            }
        }
    }

    public static void displayItemCount(List<LibraryItem> items) {
        System.out.println("Количество в библиотеке: " + items.size());
    }

    public static void listBorrowedItemsByUser(List<LibraryItem> items, User user) {
        List<LibraryItem> userItems = user.getBorrowedItems();

        for (LibraryItem item : userItems) {
            System.out.println("Книга " + item.getTitle() + " автора " + item.getAuthor() +
                    " выдана пользователю " + user.getName());
        }
        for (LibraryItem item : items) {
            if (item instanceof Borrowable borrowableItem) {
                if (!borrowableItem.isAvailable()) {
                    System.out.println("Книга " + item.getTitle() + ", Автора " + item.getAuthor()
                            + " находится в библиотеке.");
                }
            }
        }
    }

   public static void removeLostItems(List<LibraryItem> items) {
        int size = items.size();
        for (int i = 0; i < size; i++) {
            LibraryItem item = items.get(i);
            if (item instanceof Book book) {
                if (book.getStatus().equals(BookStatus.LOST)) {
                    items.remove(i);
                    size--;
                    i--;
                    System.out.println("Объект удален - " + item.getTitle() + ", " + item.getAuthor());
                }
            }
        }
    }

   public static void addItemToList(List<LibraryItem> items, LibraryItem item) {
        items.add(item);
        System.out.println("Объект успешно добавлен");
    }

    public static void removeItemFromList(List<LibraryItem> items, LibraryItem item) {
        items.remove(item);
        System.out.println("Объект удален");
    }


    public static void sortItemsByPublicationDate(List<LibraryItem> items) {
        int size = items.size();
        List<LibraryItem> sorted = new ArrayList<>(items);

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                LibraryItem item1 = sorted.get(j);
                LibraryItem item2 = sorted.get(j + 1);
                if (item1.getPublishDate().isBefore(item2.getPublishDate())) {
                    sorted.set(j, item2);
                    sorted.set(j + 1, item1);
                }
            }
        }

        System.out.println("Отсортированы по дате публикации:");
    }

    public static void findMostPopularGenre(List<LibraryItem> items) {
        Genre popular = null;
        int popularGenre = 0;
        int currentGenre = 0;

        for (LibraryItem item : items) {
            if (item instanceof Book) {
                Genre genre = item.getGenre();

                for (LibraryItem innerItem : items) {
                    if (innerItem instanceof Book && innerItem.getGenre() == genre) {
                        currentGenre++;
                    }
                }

                if (currentGenre > popularGenre) {
                    popular = genre;
                    popularGenre = currentGenre;
                }
            }
        }

        if (popular != null) {
            System.out.println("Популярный жанр" + popular);
        } else {
            System.out.println("Отсутствуют книги, на основе которых можно определить самый популярный жанр");
        }
    }

   public static void calculateAveragePageCount(List<Book> books) {
        int sum = 0;
        for (Book book : books) {
            sum += book.getPageCount();
        }
        double averagePageCount = (double) sum / books.size();
        System.out.println("Среднее количество страниц: " + averagePageCount);
    }

    public static void listMonthlyMagazines(List<Magazine> magazines) {
        List<Magazine> monthlyMagazines = new ArrayList<>();

        for (Magazine magazine : magazines) {
            if (magazine.isMonthly()) {
                monthlyMagazines.add(magazine);
            }
        }

        if (!monthlyMagazines.isEmpty()) {
            for (Magazine magazine : monthlyMagazines) {
                System.out.println("Название: " + magazine.getTitle() +
                        ", Издатель: " + magazine.getAuthor());
            }
        } else {
            System.out.println("Ежемесячные журналы не найдены");
        }
    }


    public static void listItemsByCondition(List<LibraryItem> items, ItemCondition condition) {
        List<LibraryItem> itemsByCondition = new ArrayList<>();

        for (LibraryItem item : items) {
            if (item instanceof Maintainable) {
                ItemCondition itemCondition = ((Maintainable) item).checkCondition();
                if (itemCondition == condition) {
                    itemsByCondition.add(item);
                }
            }
        }
        if (!itemsByCondition.isEmpty()) {
            System.out.println("Объекты в состоянии " + condition + ":");
            for (LibraryItem item : itemsByCondition) {
                System.out.println("Название: " + item.getTitle() +
                        ", Состояние: " + ((Maintainable) item).checkCondition());
            }
        } else {
            System.out.println("Объекты в состоянии " + condition + " не найдены");
        }
    }
}








