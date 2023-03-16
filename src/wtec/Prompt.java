package wtec;

import java.util.Scanner;

/**
 * Clase de utilidad para pedir información al usuario, siempre y cuando la
 * información sea la requerida.
 *
 * @author Martín
 */
class Prompt {

    public static int forNumber(Scanner sc, String msg) {
        int num = 0;
        boolean isNumber = false;
        do {
            try {
                num = Integer.parseInt(forString(sc, msg, false));
                if (num > 0) {
                    isNumber = true;
                } else {
                    System.out.println("error: Debe proporcionar un número positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("error: Debe proporcionar un número.");
            }
        } while (!isNumber);
        return num;
    }

    public static String forString(Scanner sc, String msg, boolean notAlphanum) {
        String str = "";
        boolean isString = false;
        boolean hasAlphanum = false;
        do {
            System.out.print(msg);
            str = sc.nextLine();
            if (!str.isBlank()) {
                if (notAlphanum) {
                    for (int i = 0; i < str.length(); i++) {
                        hasAlphanum = false;
                        char c = str.charAt(i);
                        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == ' '))) {
                            hasAlphanum = true;
                        }
                    }
                    if (!hasAlphanum) {
                        isString = true;
                    } else {
                        System.out.println("error: La cadena debe estar compuesta únicamente de letras.");
                    }
                } else {
                    isString = true;
                }
            } else {
                System.out.println("error: Debe proporcionar una cadena no vacía.");
            }
        } while (!isString);
        return str;
    }

    public static String forSex(Scanner sc, String msg) {
        String sex = "";
        boolean isSex = false;
        do {
            sex = forString(sc, msg, true);
            if (sex.matches("[MmFf]")) {
                isSex = true;
            } else {
                System.out.println("error: Debe proporcionar (M)asculino o (F)emenino.");
            }
        } while (!isSex);
        return sex.toLowerCase();
    }

    public static String forPhoneNumber(Scanner sc, String msg) {
        String phoneNum = "";
        boolean isPhoneNum = false;
        do {
            System.out.print(msg);
            phoneNum = sc.nextLine();
            if (phoneNum.matches("[0-9]{10}") && !phoneNum.matches("[0]{10}")) {
                isPhoneNum = true;
            } else {
                System.out.println("error: Debe proporcionar un número de 10 dígitos.");
            }
        } while (!isPhoneNum);
        return phoneNum;
    }
}
