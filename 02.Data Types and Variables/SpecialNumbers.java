package DataTypesAndVars;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= count; i++) {
            int num = i;
                int sum = 0;
                while (num != 0) {
                    sum += num % 10;
                    num = num / 10;
                }
                if (sum == 5 || sum == 7 || sum == 11)
                    System.out.printf("%d -> True%n", i);
                else
                    System.out.printf("%d -> False%n", i);

        }
    }
}
