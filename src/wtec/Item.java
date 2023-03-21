package wtec;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Item implements Model {

    private String name;
    private String code;
    private int amount;
    private boolean expendable;
    private String category;
    private LocalDateTime created;

    public Item() {
        this.name = "";
        this.code = "";
        this.amount = 0;
        this.expendable = false;
        this.category = "";
        this.created = LocalDateTime.now();
    }

    @Override
    public void scan(Scanner sc) {
        String cons = "";
        this.name = Prompt.forString(sc, "Nombre del producto a registrar: ", false);
        this.code = Prompt.forString(sc, "Asigne un codigo unico para el material a registrar: ", false);
        this.amount = Prompt.forNumber(sc, "Ingrese la cantidad de unidades del material: ");

        do {
            cons = Prompt.forString(sc, "Es consumible el material a registrar: /n[S] O [N]", false).toLowerCase();
            if (!"s".equals(cons) || !"n".equals(cons)) {
                System.out.println("Ingrese por favor solamente una de las 2 opciones: ");
            } else {
                this.expendable = !"s".equals(cons);
            }
        } while ((!"s".equals(cons) || !"n".equals(cons)));
    }

    @Override
    public void print() {
        System.out.println("Nombre: " + this.name);
        System.out.println("Codigo del material: " + this.code);
        System.out.println("Unidades disponibles: " + this.amount);
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
