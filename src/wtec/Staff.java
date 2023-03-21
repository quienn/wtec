package wtec;

import java.util.Scanner;

public class Staff extends Person implements Model {

    private String area;
    private String job;
    private String code;

    public Staff() {
        super();
        this.area = "";
        this.job = "";
        this.code = "";
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Área: " + this.area);
        System.out.println("Puesto: " + this.job);
        System.out.println("Código de trabajador: " + this.code);
    }

    @Override
    public void scan(Scanner sc) {
        super.scan(sc);
        this.area = Prompt.forString(sc, "Ingrese su área: ", true);
        this.job = Prompt.forString(sc, "Ingrese su puesto: ", true);
        this.code = Prompt.forString(sc, "Ingrese su código: ", true);
    }

    public void scan(Scanner sc, boolean optional) {
        this.code = Prompt.forString(sc, "Ingrese su código: ", true);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
