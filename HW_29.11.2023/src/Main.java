import Library.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static Library.CollectionProcessor.*;

public class Main {
    public static void main(String[] args) {

        List<LibraryItem> libraryItemList = new ArrayList<>();
        User user = new User("Павел", 123, "");

        libraryItemList.add(new Book("Ася", "Иван Тургенев", Genre.FICTION, BookStatus.AVAILABLE, LocalDate.of(1858, 5, 2), 123));
        libraryItemList.add(new Book("Яд бессмертия", "Нора Робертс", Genre.NON_FICTION, BookStatus.LOST, LocalDate.of(1996, 4, 27), 240));
        libraryItemList.add(new Book("Знак четырех", "Артур Конан Дойл", Genre.BIOGRAPHY, BookStatus.UNDER_REPAIR, LocalDate.of(1996, 10, 15), 300));
        libraryItemList.add(new Magazine("Наука и техника", "Беспалова Н. Ю.", Genre.SCIENCE, 15, LocalDate.of(2023, 12, 2), false));

        printAllItems(libraryItemList);
        System.out.println();

        listItemsByGenre(libraryItemList, Genre.FICTION);
        System.out.println();

        sortByTitle(libraryItemList);
        System.out.println();

        filterByAuthor(libraryItemList, "Нора Робертс");
        System.out.println();

        countItemsByStatus(libraryItemList, BookStatus.AVAILABLE);
        System.out.println();

        updateStatus(libraryItemList, BookStatus.AVAILABLE, BookStatus.BORROWED);
        System.out.println();

        listAvailableItems(libraryItemList);
        System.out.println();

        LibraryItem oldestItem = findOldestItem(libraryItemList);
        System.out.println("Самый старый элемент: " + oldestItem.getTitle() +
                ", Автор: " + oldestItem.getAuthor() +
                ", Дата публикации: " + oldestItem.getPublishDate());
        System.out.println();

        groupItemsByAuthor(libraryItemList);
        System.out.println();

        listItemsForRepair(libraryItemList);
        System.out.println();

        displayItemCount(libraryItemList);
        System.out.println();

        listBorrowedItemsByUser(libraryItemList, user);
        System.out.println();

        removeLostItems(libraryItemList);
        System.out.println();

        List<LibraryItem> items = new ArrayList<>();
        Book newBook = new Book("Новое название", "Новый автор", Genre.BIOGRAPHY, BookStatus.UNDER_REPAIR, LocalDate.of(1997, 10, 13), 255);
        addItemToList(items, newBook);
        System.out.println();

        removeItemFromList(items, newBook);
        System.out.println();

        sortItemsByPublicationDate(libraryItemList);
        System.out.println();

        findMostPopularGenre(libraryItemList);
        System.out.println();

        List<Book> books = new ArrayList<>();

        books.add(new Book("Ася", "Иван Тургенев", Genre.FICTION, BookStatus.AVAILABLE, LocalDate.of(1858, 5, 2), 123));
        books.add(new Book("Яд бессмертия", "Нора Робертс", Genre.NON_FICTION, BookStatus.LOST, LocalDate.of(1996, 4, 27), 240));
        books.add(new Book("Знак четырех", "Артур Конан Дойл", Genre.BIOGRAPHY, BookStatus.UNDER_REPAIR, LocalDate.of(1996, 10, 15), 300));

        calculateAveragePageCount(books);
        System.out.println();

        List<Magazine> magazines = new ArrayList<>();
        magazines.add(new Magazine("Наука и техника", "Беспалова Н. Ю.", Genre.SCIENCE, 15, LocalDate.of(2023, 12, 2), false));

        listMonthlyMagazines(magazines);
        System.out.println();


        listItemsByCondition(items, ItemCondition.LOST);
        System.out.println();
    }

}