public class Player {
    private String firstName;
    private String lastName;
    private char symbol;

    public Player setSymbol(char symbol) {
        this.symbol = symbol;
        return this;
    }

    public Player setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Player setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
