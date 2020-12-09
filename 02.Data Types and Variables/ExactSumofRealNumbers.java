package DataTypesAndVars;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumofRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        BigDecimal sum = new BigDecimal("0");
        for (int i = 1; i <= count; i++) {
            BigDecimal numb = new BigDecimal(scan.nextLine());
            sum = sum.add(numb);
        }
        System.out.println(sum);
    }
}
