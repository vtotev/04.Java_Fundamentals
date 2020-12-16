package DataTypesAndVars;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startingYield = Integer.parseInt(scan.nextLine());
        int days = 0;
        int spicesExtracted = 0;
        if (startingYield > 99) {
            while (startingYield >= 100) {
                spicesExtracted += (startingYield - 26);
                startingYield -= 10;
                days++;
            }
            spicesExtracted -= 26;
            System.out.println(days);
            System.out.println(spicesExtracted);
        } else {
            System.out.printf("0%n0");
        }
    }
}
