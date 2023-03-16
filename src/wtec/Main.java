package wtec;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Student[] alumni = new Student[1000];

        int opt = 0;
        do {
            System.out.println("1. Registrar Estudiante...");
            System.out.println("2. Mostrar Estudiantes...");

            opt = Prompt.forNumber(scanner, "Ingrese una opción: ");

            switch (opt) {
            case 1 -> {
                new Student().scan(scanner);
            }
            }
        } while (opt != 3);
    }
}
