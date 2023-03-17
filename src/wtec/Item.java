package wtec;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Item implements Model {

    private String name;
    private String code;
    private int amount;
    private boolean expendable;
    private LocalDateTime created;

    public Item() {
        this.name = "";
        this.code = "";
        this.amount = 0;
        this.expendable = false;
        this.created = LocalDateTime.now();
    }

    @Override
    public void scan(Scanner sc) {
        // @TODO Pedir datos aquí. De mientras nada porque quiero probar lo de la serialización
    }

    @Override
    public void print() {
        // @TODO Mostrar datos aquí. De mientras nada porque quiero probar lo de la serialización
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
