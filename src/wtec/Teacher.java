package wtec;

import java.util.Scanner;

public class Teacher extends Staff implements Model {

    private String[] assignedSubjects;

    public Teacher() {
        super();
        setJob("teacher");
        setArea("teaching");
    }

    @Override
    public void scan(Scanner sc) {
        super.scan(sc, true);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Materias que imparte: ");
        for (String assignedSubject : assignedSubjects) {
            System.out.println("* " + assignedSubject);
        }
    }
}
