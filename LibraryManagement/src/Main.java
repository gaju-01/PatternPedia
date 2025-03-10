import Book.Book;
import BookCategory.BookCategory;
import BookCategory.NovelsCategory;
import BookCategory.TechnicalCategory;
import Book.BookItem;
import LibraryCard.LibraryCard;
import LibraryInfra.Shelf;
import Person.User;
import Book.BookItemManager;
import Book.BookItemTicket;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User lokesh = new User(1, "Lokesh", "Bharadwaj");
        User alok = new User(2, "Alok", "Singh");

        LibraryCard libraryCard0 = new LibraryCard(lokesh, LocalDate.now(), LocalDate.now());
        LibraryCard libraryCard1 = new LibraryCard(alok, LocalDate.now(), LocalDate.now());

        libraryCard0.printDetails();
        libraryCard1.printDetails();

        Book harryPotter = new Book(1, "Harry Potter");
        Book cleanCode = new Book(2, "Clean Code");

        BookItem harryPotterCopy0 = new BookItem(1, harryPotter);
        BookItem harryPotterCopy1 = new BookItem(2, harryPotter);
        BookItem cleanCodeCopy0 = new BookItem(3, cleanCode);
        BookItem cleanCodeCopy1 = new BookItem(4, cleanCode);

        BookCategory novelsCategory = NovelsCategory.getNovelsCategoryInstance(1,"NovelsCategory");
        BookCategory techCategory = TechnicalCategory.getTechnicalCategoryInstance(2, "TechCategory");

        novelsCategory.addBook(harryPotter);
        techCategory.addBook(cleanCode);

        Shelf techShelf = new Shelf(1);
        techShelf.addBookItem(cleanCodeCopy0);
        techShelf.addBookItem(cleanCodeCopy1);

        Shelf novelShelf = new Shelf(2);
        novelShelf.addBookItem(harryPotterCopy0);

        Shelf tempNovelShelf = new Shelf(3);
        tempNovelShelf.addBookItem(harryPotterCopy1);

        System.out.println("Enter the category you want to select");
        System.out.println("1: Novels                2: Technical");
        int index = scanner.nextInt();
        List<Book> bookList;
        if(index == 1)  {
            bookList  = novelsCategory.showAvailableBooks();
        } else {
            bookList = techCategory.showAvailableBooks();
        }
        for (Book book : bookList) {
            book.printDetails();
        }

        Book myBook = null;
        System.out.println("Enter the book id you want to select");
        while(true) {
            int bookId = scanner.nextInt();
            for (Book book : bookList) {
                if(bookId == book.getId()) {
                    myBook = book;
                    break;
                }
            }

            if(myBook != null) break;
            System.out.println("Enter the valid book id");
        }

        BookItemManager  bookItemManager = BookItemManager.getBookItemManagerInstance();
        List<Shelf> shelves = bookItemManager.showAvailableBooks(myBook);
        System.out.println("Book present in the locations");
        for(Shelf shelf: shelves) {
            System.out.println(shelf.getId());
        }

        BookItemTicket bookItemTicket0 = bookItemManager.bookTheBook(myBook, libraryCard0);
        BookItemTicket bookItemTicket1 = bookItemManager.bookTheBook(myBook, libraryCard1);

        bookItemTicket0.printDetails();
        bookItemTicket1.printDetails();
    }
}