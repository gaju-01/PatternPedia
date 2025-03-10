package LibraryCard;

import Person.User;

import java.time.LocalDate;

public class LibraryCard {

    private LocalDate startDate;

    private LocalDate endDate;

    private User user;

    public LibraryCard(User user, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        user.setLibraryCard(this);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void printDetails() {
        user.printDetails();
        System.out.println("Start Date: " + this.startDate);
        System.out.println("End Date: " + this.endDate);
        System.out.println("***********************************************");
    }

    public User getUser() {
        return this.user;
    }
 }
