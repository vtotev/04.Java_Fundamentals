package DataTypesAndVars;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        boolean isSpecialNum = false;
        for (int i = 1; i <= count; i++) {
            int number = i;
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number = number / 10;
            }
            isSpecialNum = (sum == 5) || (sum == 7) || (sum == 11);
            if (isSpecialNum)
                System.out.printf("%d -> True%n", i);
            else
                System.out.printf("%d -> False%n", i);
            sum = 0;
        }

    }
}
