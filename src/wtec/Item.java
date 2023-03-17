package wtec;

import java.util.Scanner;

public class Item {

    Scanner sc = new Scanner(System.in);
    private String nameItem;
    private String codeItem;
    private int amount;
    private boolean expendable;

    public Item(String nameItem, String codeItem, int amount, boolean expendable) {
        this.nameItem = nameItem;
        this.codeItem = codeItem;
        this.amount = amount;
        this.expendable = expendable;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getCodeItem() {
        return codeItem;
    }

    public void setCodeItem(String codeItem) {
        this.codeItem = codeItem;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isExpendable() {
        return expendable;
    }

    public void setExpendable(boolean expendable) {
        this.expendable = expendable;
    }

}
