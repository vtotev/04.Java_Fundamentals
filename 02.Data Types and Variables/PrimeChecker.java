package DataTypesAndVars;

import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 2; i <= count; i++) {
            boolean isPrime = true;
            for (int divider = 2; divider < i; divider++)
            {
                if (i % divider == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.printf("%d -> true%n", i);
            } else
                System.out.printf("%d -> false%n", i);
        }
    }
}
