package DataTypesAndVars;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nLines = Integer.parseInt(scan.nextLine());
        int openingBrackets = 0;
        int closingBrackets = 0;
        for (int i = 1; i <= nLines; i++) {
            String inp = scan.nextLine();

            if (inp.equals("(")) openingBrackets++;
            if (inp.equals(")")) {
                closingBrackets++;
                if (openingBrackets - closingBrackets != 0) {
                    System.out.println("UNBALANCED");
                    return;
                }
            }
        }
            if (openingBrackets == closingBrackets) {
                System.out.println("BALANCED");
            } else
                System.out.println("UNBALANCED");
    }
}
