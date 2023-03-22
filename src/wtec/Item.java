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
        int categoryKindOpt = 0;
        this.name = Prompt.forString(sc, "Nombre del producto a registrar: ", false);
        this.code = Prompt.forString(sc, "Asigne un codigo unico para el material a registrar: ", false);
        this.amount = Prompt.forNumber(sc, "Ingrese la cantidad de unidades del material: ");

        do {
            System.out.println("+----------Tipo de categoria----------+");
            System.out.println("1. Servicios generales ");
            System.out.println("2. Laboratorio");
            categoryKindOpt = Prompt.forNumber(sc, "Seleccione una opcion del menu: ");
            if (categoryKindOpt <= 2) {
                switch (categoryKindOpt) {
                    case 1 -> {
                        this.category = "limpieza";
                    }
                    case 2 -> {
                        this.category = "laboratorio";
                    }
                    default -> {
                        System.out.println("Error, por favor proceda a poner algo bien");
                    }
                }
            } else {
                System.out.println("error: Elige una de las opciones presentadas");
            }
        } while (!(categoryKindOpt <= 2));

        do {
            cons = Prompt.forString(sc, "Es consumible el material a registrar: \n [S] O [N]", true).toLowerCase();
            if ("s".equals(cons) || "n".equals(cons)) {
                this.expendable = cons.equals("s");
            } else {
                System.out.println("Ingrese por favor solamente una de las 2 opciones: ");
            }
        } while (!(cons.equals("s") || cons.equals("n")));
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
