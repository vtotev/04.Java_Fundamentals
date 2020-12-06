package DataTypesAndVars;

import java.util.Scanner;

public class CharstoString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstChas = scan.nextLine();
        String secChar = scan.nextLine();
        String thirdChar = scan.nextLine();
        System.out.println(firstChas+secChar+thirdChar);
    }
}
