package wtec;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    
    private static <T> void saveToDisk(T[] object, String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
        } catch (IOException e) {
            System.out.println("error: No se pudo guardar la información.");
        }
    }
    
    private static <T> void saveToDisk(T object, String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
        } catch (IOException e) {
            System.out.println("error: No se pudo guardar la información.");
        }
    }
    
    private static <T> T loadObject(String filename) {
        T obj = null;
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fin);
            obj = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error: No se pudo cargar la informacion del objeto.");
        }
        return obj;
    }
    
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        
        Person[] users;
        Item[] items;
        Loan[] loans;
        Settings settings;
        
        settings = loadObject("settings.dat");
        if (settings == null) {
            System.out.println("error: El archivo de ajustes no fue encontrado.");
            System.out.println("Creando uno nuevo...");
            
            settings = new Settings();
            settings.setUsersSize(Prompt.forNumber(scanner, "Ingrese la cantidad de usuarios: "));
            settings.setItemsSize(Prompt.forNumber(scanner, "Ingrese la cantidad de materiales: "));
        }
        
        users = loadObject("users.dat");
        if (users == null) {
            System.out.println("Creando un objeto para contener los usuarios...");
            users = new Person[settings.getUsersSize()];
        }
        items = loadObject("items.dat");
        if (items == null) {
            System.out.println("Creando un objeto para contener los materiales...");
            items = new Item[settings.getItemsSize()];
        }
        loans = loadObject("loans.dat");
        if (loans == null) {
            System.out.println("Creando un objeto para contener los prestamos...");
            loans = new Loan[500];
        }
        
        int opt = 0, newKindOpt = 0, queryKindOpt = 0, itemKindOpt = 0, itemScanOpt = 0, itemPrintOpt = 0;
        
        do {
            
            System.out.println("+----------Usuarios----------+");
            System.out.println("1. Registrar...");
            System.out.println("2. Consultar...");
            System.out.println("+----------Materiales----------+");
            System.out.println("3. Registrar...");
            System.out.println("4. Salir");
            
            opt = Prompt.forNumber(scanner, "Ingrese una opción: ");
            
            switch (opt) {
                // Menú para registros
                case 1 -> {
                    Person newUser = null;
                    
                    System.out.println("+----------Registro----------+");
                    System.out.println("1. Estudiante");
                    System.out.println("2. Almacenista");
                    System.out.println("3. Maestro");
                    System.out.println("4. Cancelar");
                    
                    newKindOpt = Prompt.forNumber(scanner, "Ingrese el tipo de usuario a registrar: ");
                    
                    switch (newKindOpt) {
                        case 1 -> {
                            newUser = new Student();
                            ((Student) newUser).scan(scanner);
                        }
                        case 2 -> {
                            newUser = new Storer();
                            ((Storer) newUser).scan(scanner, true);
                        }
                        case 3 -> {
                            newUser = new Teacher();
                            ((Teacher) newUser).scan(scanner);
                        }
                        case 4 -> {
                            System.out.println("Se eligió la opción de cancelar registro. Cancelando cambios...");
                        }
                        default ->
                            System.out.println("error: Opción incorrecta.");
                    }
                    
                    if (newUser == null) {
                        System.out.println("error: Registro cancelado.");
                    } else {
                        users[settings.getUsersCount()] = newUser;
                        settings.setUsersCount(settings.getUsersCount() + 1);
                    }
                }

                // Menú de consultas
                case 2 -> {
                    do {
                        System.out.println("+----------Consulta----------+");
                        System.out.println("1. Mostrar Todos");
                        System.out.println("2. Mostrar por Tipo");
                        System.out.println("3. Buscar...");
                        System.out.println("4. Volver");
                        
                        queryKindOpt = Prompt.forNumber(scanner, "Ingrese una opcion: ");
                        
                        switch (queryKindOpt) {
                            case 1 -> {
                                System.out.println("+----------Usuarios----------+");
                                for (int i = 0; i < settings.getUsersCount(); i++) {
                                    users[i].print();
                                    System.out.println("+--------------------");
                                }
                            }
                            
                            case 2 -> {
                            }
                            
                            case 3 -> {
                                
                            }
                            
                            case 4 -> {
                            }
                            
                            default -> {
                                System.out.println("error: Opción incorrecta.");
                            }
                        }
                    } while (queryKindOpt != 4);
                }
                //Menu de materiales

                case 3 -> {
                    
                    System.out.println("+----------Registro----------+");
                    System.out.println("1. Material");
                    System.out.println("2. Prestamo");
                    System.out.println("3. Cancelar");
                    
                    newKindOpt = Prompt.forNumber(scanner, "Ingrese el tipo de usuario a registrar: ");
                    
                    switch (newKindOpt) {
                        case 1 -> {
                            Item newItem = new Item();
                            if (settings.getItemsCount() < settings.getItemsSize()) {
                                newItem.scan(scanner);
                                items[settings.getItemsCount()] = newItem;
                                settings.setItemsCount(settings.getItemsCount() + 1);
                            } else {
                                System.out.println("La cantidad maxima de materiales asignada se ha alcanzado");
                            }
                        }
                        case 2 -> {
                            Loan newLoan = new Loan();
                            if (settings.getLoanCount() < loans.length) {
                                newLoan.scan(scanner);
                                loans[settings.getLoanCount()] = newLoan;
                                settings.setLoanCount(settings.getLoanCount() + 1);
                            } else {
                                System.out.println("Capacidad de prestamos maxima alcanzada");
                            }
                        }
                        case 3 -> {
                            System.out.println("Se eligió la opción de cancelar registro. Cancelando cambios...");
                        }
                        default ->
                            System.out.println("error: Opción incorrecta.");
                    }

//                    do {
//                        System.out.println("+----------Materiales----------+");
//                        System.out.println("1. Registros...");
//                        System.out.println("2. Consulta...");
//                        System.out.println("3. Volver");
//                        itemKindOpt = Prompt.forNumber(scanner, "Ingrese una opcion del menu ");
//
//                        switch (itemKindOpt) {
//                            case 1 -> {
//
//                                do {
//                                    System.out.println("+----------Registros de materiales----------+");
//                                    System.out.println("1. Registro de material...");
//                                    System.out.println("2. Registro de un prestamo...");
//                                    System.out.println("3. Volver");
//                                    itemScanOpt = Prompt.forNumber(scanner, "Seleccione la opcion que requiera: ");
//                                    switch (itemScanOpt) {
//                                        case 1 -> {
//
//                                        }
//                                        case 2 -> {
//
//                                        }
//                                        default -> {
//                                            System.out.println("Que haces vato? pon algo bien");
//                                        }
//                                    }
//                                } while (itemScanOpt != 3);
//
//                            }
//                            case 2 -> {
//                                do {
//                                    System.out.println("+----------Consultas----------+");
//                                    System.out.println("1. Consulta materiales existentes...");
//                                    System.out.println("2. Consulta prestamos efectuados...");
//                                    System.out.println("3. Volver");
//                                    itemPrintOpt = Prompt.forNumber(scanner, "Seleccione una opcion: ");
//                                    switch (itemPrintOpt) {
//                                        case 1 -> {
//
//                                        }
//                                        case 2 -> {
//
//                                        }
//                                        default -> {
//                                            System.out.println("Va pero pon algo bien o kue?");
//                                        }
//                                    }
//
//                                } while (itemPrintOpt != 3);
//                            }
//                            default -> {
//                                System.out.println("Error: opcion incorrecta");
//                            }
//                        }
//
//                    } while (itemKindOpt != 3);
                }
                default ->
                    System.out.println("error: Opción incorrecta.");
            }
        } while (opt != 4);
        
        saveToDisk(settings, "settings.dat");
        saveToDisk(users, "users.dat");
        saveToDisk(items, "items.dat");
        saveToDisk(loans, "loans.dat");
        
        scanner.close();
    }
}
