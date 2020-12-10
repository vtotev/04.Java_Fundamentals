package DataTypesAndVars;

import java.util.Scanner;

public class LowerorUpper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String charac = scan.nextLine();
        if (charac.toUpperCase().equals(charac)) {
            System.out.println("upper-case");
        } else System.out.println("lower-case");
    }
}
