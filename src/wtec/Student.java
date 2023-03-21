package wtec;

import java.util.Scanner;

public class Student extends Person implements Model {

    private String code;
    private int semester;
    private String career;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Student() {
        super();
        this.code = "";
        this.semester = 0;
        this.career = "";
    }

    @Override
    public void scan(Scanner sc) {
        super.scan(sc);
        this.code = Prompt.forString(sc, "Ingrese el código de estudiante: ", false);
        this.semester = Prompt.forNumber(sc, "Ingrese su semestre: ");
        this.career = Prompt.forString(sc, "Ingrese su carrera: ", true);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Código: " + code);
        System.out.println("Carrera: " + career);
        System.out.println("Semestre: " + semester);
    }
}
