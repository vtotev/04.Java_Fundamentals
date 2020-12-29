package Methods;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputPassword = scan.nextLine();
        validatePassword(inputPassword);
    }

    private static void validatePassword(String inputPassword) {
        boolean isLength = checkLength(inputPassword);
        int lettCount = checkLetters(inputPassword);
        int digCount = CheckDigits(inputPassword);

        if (!isLength) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (((lettCount + digCount) != inputPassword.length()) || (digCount == inputPassword.length()))
            System.out.println("Password must consist only of letters and digits");

        if (digCount < inputPassword.length() && digCount < 2) {
            System.out.println("Password must have at least 2 digits");
            return;
        }

        if (isLength && (lettCount + digCount) == inputPassword.length() && digCount < inputPassword.length() && digCount > 1) {
            System.out.println("Password is valid");
        }
    }

    private static int checkLetters(String inputPassword) {
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int LetterC = 0;
        for (int i = 0; i < inputPassword.length(); i++) {
            if (letters.contains(inputPassword.charAt(i) + "")) {
                LetterC++;
            }
        }
        return LetterC;
    }

    private static int CheckDigits(String inputPassword) {
        String digits = "0123456789";
        int digitCount = 0;
        for (int i = 0; i < inputPassword.length(); i++) {
            if (digits.contains(inputPassword.charAt(i) + "")) {
                digitCount++;
            }
        }
        return digitCount;
    }

    private static boolean checkLength(String inputPassword) {
        if (inputPassword.length() >= 6 && inputPassword.length() <= 10)
            return true;
        else return false;
    }
}
