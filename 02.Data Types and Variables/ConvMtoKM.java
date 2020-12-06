package DataTypesAndVars;

import java.util.Scanner;

public class ConvMtoKM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int met = Integer.parseInt(scan.nextLine());
        double km = (double) met / 1000;
        System.out.printf("%.2f", km);
    }
}
