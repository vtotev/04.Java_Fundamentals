package DataTypesAndVars;

import java.util.Scanner;

public class PrintPartASCIITable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        for (int i = start; i <= end; i++) {
            char character = (char)i;
            System.out.print(character + " ");
        }
    }
}
