package wtec;

import java.util.Scanner;

public class Teacher extends Staff {

    public Teacher() {
        super();
        setJob("teacher");
        setArea("teaching");
    }

    @Override
    public void scan(Scanner sc) {
        super.scan(sc, true);
    }
}
