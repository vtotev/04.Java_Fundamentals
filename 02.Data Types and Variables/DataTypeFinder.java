package DataTypesAndVars;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("END")) {
            int charsNum = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '0' || input.charAt(i) == '1' || input.charAt(i) == '2' ||
                        input.charAt(i) == '3' || input.charAt(i) == '4' || input.charAt(i) == '5' ||
                        input.charAt(i) == '6' || input.charAt(i) == '7' || input.charAt(i) == '8' ||
                        input.charAt(i) == '9' || input.charAt(i) == '-' || input.charAt(i) == '.')
                    charsNum++;
            }

            if (input.toLowerCase().equals("true") || input.toLowerCase().equals("false")) {
                System.out.printf("%s is boolean type%n", input);
            } else if (charsNum == input.length()) {
                 if (input.contains(".")) {
                     System.out.printf("%s is floating point type%n", input);
                 } else System.out.printf("%s is integer type%n", input);
            } else if (input.length() == 1) {
                System.out.printf("%s is character type%n", input);
            } else System.out.printf("%s is string type%n", input);
            input = scan.nextLine();
        }
    }
}
