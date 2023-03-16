package wtec;

import java.io.Serializable;
import java.util.Scanner;

public interface Model extends Serializable {

    void scan(Scanner scanner);

    void print();
}
