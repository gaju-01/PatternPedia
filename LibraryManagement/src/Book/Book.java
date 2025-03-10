package Book;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private int id;

    private String name;

    private List<BookItem>  bookItemList;

    public Book(int  id, String name) {
        this.id = id;
        this.name = name;
        this.bookItemList = new ArrayList<>();
    }

    public void printDetails() {
        System.out.println("Book id: " + id);
        System.out.println("Book name: " + name);
        System.out.println("**************************************");
    }

    public void addBookItem(BookItem bookItem) {
        this.bookItemList.add(bookItem);
    }

    public int getId() {
        return this.id;
    }

    public List<BookItem> getBookItemList() {
        return this.bookItemList;
    }

    public String getName() {
        return this.name;
    }
}
