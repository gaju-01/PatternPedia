package BookCategory;

import Book.Book;

import java.util.ArrayList;
import java.util.List;

public abstract class BookCategory {

    private int id;

    private String name;

    private List<Book> bookList;

    public BookCategory(int  id, String name) {
        this.id = id;
        this.name = name;
        this.bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public List<Book> showAvailableBooks() {
        return this.bookList;
    }
}
