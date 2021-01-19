package TextProcessing;

import java.util.Scanner;

public class DigitsLettersАndOther {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String chars = "";
        String digits = "";
        String symbs = "";
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                chars += input.charAt(i);
            } else if (Character.isDigit(input.charAt(i))) {
                digits += input.charAt(i);
            } else {
                symbs += input.charAt(i);
            }
        }
        System.out.println(digits);
        System.out.println(chars);
        System.out.println(symbs);
    }
}
