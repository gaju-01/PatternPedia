package Person;

public class Person {

    private int id;

    private String firstName;

    private String lastName;

    Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void printDetails() {
        System.out.println("First name: " + this.firstName);
        System.out.println("Last name: " + this.lastName);
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}
