package Book;

import LibraryCard.LibraryCard;
import LibraryInfra.Shelf;

public class BookItem {
    private int id;

    private Shelf shelf;
    private Book book;

    private BookItemTicket bookItemTicket;

    public BookItem(int id, Book book) {
        this.id = id;
        this.book = book;
        this.bookItemTicket = null;
        book.addBookItem(this);
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public Shelf getShelf() {
        return this.shelf;
    }

    public void setBookItemTicket(BookItemTicket bookItemTicket) {
        this.bookItemTicket = bookItemTicket;
    }

    public BookItemTicket getBookItemTicket() {
        return this.bookItemTicket;
    }

    public Book getBook() {
        return this.book;
    }
}
