package DataTypesAndVars;

import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numA = Double.parseDouble(scan.nextLine());
        double numB = Double.parseDouble(scan.nextLine());
        double eps = 0.000001f;
        double compare = Math.abs(numA - numB);
        if (compare < eps) {
            System.out.println("True");
        }
        else
            System.out.println("False");
    }
}
