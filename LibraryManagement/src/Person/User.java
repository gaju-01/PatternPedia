package Person;

import LibraryCard.LibraryCard;

public class User extends Person{

    private LibraryCard libraryCard;

    public User(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }
}
