package DataTypesAndVars;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int remain = number;
        int sum = 0;
        while (remain > 0) {
            sum += remain % 10;
            remain = remain / 10;
        }
        System.out.println(sum);
    }
}
