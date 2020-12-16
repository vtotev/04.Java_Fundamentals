package DataTypesAndVars;

import java.util.Scanner;

public class SumofChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        int charSum = 0;
        for (int i = 0; i < count; i++) {
            char character = scan.nextLine().charAt(0);
            charSum += character;
        }
        System.out.printf("The sum equals: %d", charSum);
    }
}
