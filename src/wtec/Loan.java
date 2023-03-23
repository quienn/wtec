package wtec;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Loan implements Model {

    private String code;
    private Item item;
    private LocalDateTime created;
    private LocalDateTime returned;
    private boolean wasReturned;
    private Storer inCharge;
    private Person borrower;

    public Loan() {
        this.code = "";
        this.item = null;
        this.created = LocalDateTime.now();
        this.returned = null;
        this.inCharge = null;
        this.borrower = null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getReturned() {
        return returned;
    }

    public void setReturned(LocalDateTime returned) {
        this.returned = returned;
    }

    public Storer getInCharge() {
        return inCharge;
    }

    public void setInCharge(Storer inCharge) {
        this.inCharge = inCharge;
    }

    public Person getBorrower() {
        return borrower;
    }

    public void setBorrower(Person borrower) {
        this.borrower = borrower;
    }

    @Override
    public void scan(Scanner scanner) {
    }

    public void scan(Scanner scanner, Person[] users, int usersCount, Item[] items) {
        Person pInCharge, pBorrow;

        do {
            for (int i = 0; i < usersCount; i++) {
                if (users[i].getClass() == Storer.class) {
                    System.out.println("Usuario [" + i + "]: ");
                    users[i].print();
                }
            }

            pInCharge = users[Prompt.forNumber(scanner, "Ingrese el usuario del prestamista: ")];
            if (pInCharge == null) {
                System.out.println("error: Elija un usuario valido.");
            }
        } while (pInCharge != null);
        this.inCharge = (Storer) pInCharge;
    }

    @Override
    public void print() {
    }

}
