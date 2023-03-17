package wtec;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

    private static <T> void saveToDisk(T[] arrayObject, String filename) {
    }

    private static <T> void saveToDisk(T object, String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
        } catch (IOException e) {
            System.out.println("error: No se pudo guardar la información.");
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        Settings settings;
        {
            try {
                FileInputStream settingsFile = new FileInputStream("settings.dat");
                ObjectInputStream settingsObject = new ObjectInputStream(settingsFile);

                settings = (Settings) settingsObject.readObject();
            } catch (Exception e) {
                switch (e) {
                    case FileNotFoundException __ -> {
                        System.out.println("error: El archivo de ajustes no fue encontrado.");
                        System.out.println("Creando uno nuevo...");
                    }
                    default -> {
                        System.out.println("error: Ocurrió un error al cargar el archivo.");
                    }
                }

                settings = new Settings();

                settings.setStaffSize(Prompt.forNumber(scanner, "Ingrese la cantidad de administrativos: "));
                settings.setAlumniSize(Prompt.forNumber(scanner, "Ingrese la cantidad de alumnos: "));
                settings.setItemsSize(Prompt.forNumber(scanner, "Ingrese la cantidad de materiales: "));
            }
        }

        Staff[] staff;
        Student[] alumni;
        Item[] items;

        staff = new Staff[settings.getStaffSize()];
        alumni = new Student[settings.getAlumniSize()];
        items = new Item[settings.getItemsSize()];

        int opt;
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

        saveToDisk(settings, "settings.dat");
        saveToDisk(staff, "staff.dat");
        saveToDisk(alumni, "alumni.dat");
        saveToDisk(items, "items.dat");

        scanner.close();
    }
}
