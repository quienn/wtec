package wtec;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Loan implements Model {

    private String code;
    private Item item;
    private LocalDateTime created;
    private LocalDateTime returned;
    private Storer inCharge;
    private Person borrower;

    public Loan() {
        this.code = "";
        this.item = null;
        this.created = null;
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

    @Override
    public void print() {
    }

}
