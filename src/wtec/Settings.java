package wtec;

import java.io.Serializable;

public class Settings implements Serializable {

    private int usersCount;
    private int itemsCount;

    private int usersSize;
    private int itemsSize;

    private int loanCount;

    public Settings() {
        this.itemsCount = 0;
        this.itemsSize = 0;
        this.loanCount = 0;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public int getUsersSize() {
        return usersSize;
    }

    public void setUsersSize(int usersSize) {
        this.usersSize = usersSize;
    }

    public int getLoanCount() {
        return loanCount;
    }

    public void setLoanCount(int loanCount) {
        this.loanCount = loanCount;
    }

    public int getItemsSize() {
        return itemsSize;
    }

    public void setItemsSize(int itemsSize) {
        this.itemsSize = itemsSize;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }
}
