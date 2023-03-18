package wtec;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Model {

    private String name;
    private int age;
    private String sex;
    private String phone;
    private String address;

    public Person() {
        name = "";
        age = 0;
        sex = "";
        phone = "";
        address = "";
    }

    @Override
    public void scan(Scanner sc) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("SECCION PARA REGISTRO DE UNA PERSONA");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        this.name = Prompt.forString(sc, "-------------------------------\nIngrese el nombre a registrar: \n-------------------------------", true);
        this.age = Prompt.forNumber(sc, "-----------------------------\nIngrese la edad a registrar: \n-----------------------------");
        this.sex = Prompt.forSex(sc, "------------------\nFacilite el sexo: \n------------------");
        this.phone = Prompt.forPhoneNumber(sc, "-----------------------------------\nAhora introduzca el numero telefonico: \n-----------------------------------");
        this.address = Prompt.forString(sc, "---------------------------------------\nAhora ingrese el domicilio pertinente: \n---------------------------------------", false);
    }

    @Override
    public void print() {
        System.out.println("Nombre: " + this.name);
        System.out.println("Edad: " + this.age);
        System.out.println("Sexo:" + this.sex);
        System.out.println("Numero telefonico: " + this.phone);
        System.out.println("Domicilio: " + this.address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
