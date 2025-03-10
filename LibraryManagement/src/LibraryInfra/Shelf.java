package LibraryInfra;

import Book.BookItem;
import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private int id;

    private List<BookItem>  bookItemList;

    public Shelf(int id) {
        this.id = id;
        this.bookItemList = new ArrayList<>();
    }

    public void addBookItem(BookItem bookItem) {
        bookItem.setShelf(this);
        this.bookItemList.add(bookItem);
    }

    public int getId() {
        return this.id;
    }
}
