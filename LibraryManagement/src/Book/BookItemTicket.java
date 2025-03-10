package Book;

import LibraryCard.LibraryCard;

import java.time.LocalDate;

public class BookItemTicket {

    private LocalDate startDate;

    private LocalDate endDate;


    private LibraryCard libraryCard;

    private BookItem bookItem;

    public BookItemTicket(LocalDate startDate, LocalDate endDate, LibraryCard libraryCard, BookItem bookItem) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.libraryCard = libraryCard;
        this.bookItem = bookItem;
        this.bookItem.setBookItemTicket(this);
    }

    public void printDetails() {
        System.out.println("Book Name: " + this.bookItem.getBook().getName());
        System.out.println("Start Date: " + this.startDate);
        System.out.println("End Date: " + this.endDate);
        System.out.println("Borrowed By: " + this.libraryCard.getUser().getName());
        System.out.println("******************************************************************");
    }
}
