package Methods;

import java.util.Scanner;

public class CharactersinRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char firstChar = scan.nextLine().charAt(0);
        char secondChar = scan.nextLine().charAt(0);
        printCharsInBetween(firstChar, secondChar);
    }

    private static void printCharsInBetween(char firstChar, char secondChar) {
        int firstCharNum = (int) firstChar + 1;
        int secondCharNum = secondChar;
        if (firstCharNum < secondCharNum) {
            for (int i = firstCharNum; i < secondCharNum; i++) {
                System.out.print((char) i + " ");
            }
        } else {
            for (int i = secondCharNum+1; i < firstCharNum-1; i++) {
                System.out.print((char) i + " ");
            }
        }
    }
}
