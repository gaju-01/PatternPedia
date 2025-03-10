package Book;

import LibraryCard.LibraryCard;
import LibraryInfra.Shelf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookItemManager {

    public static volatile BookItemManager bookItemManager;

    public static BookItemManager getBookItemManagerInstance() {
        if(bookItemManager == null) {
            synchronized (BookItemManager.class) {
                if(bookItemManager == null) {
                    bookItemManager = new BookItemManager();
                }
            }
        }

        return bookItemManager;
    }

    private  BookItemManager() {}

    public List<Shelf> showAvailableBooks(Book book) {
        List<Shelf> shelves = new ArrayList<>();
        for(BookItem bookItem: book.getBookItemList()) {
            if(bookItem.getBookItemTicket() == null) {
                shelves.add(bookItem.getShelf());
            }
        }

        return shelves;
    }

    public BookItemTicket bookTheBook(Book book, LibraryCard libraryCard) {
        for(BookItem bookItem: book.getBookItemList()) {
            if(bookItem.getBookItemTicket() == null) {
                return new BookItemTicket(LocalDate.now(), LocalDate.now(), libraryCard, bookItem);
            }
        }

        return null;
    }
}
