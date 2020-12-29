package Methods;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        printTopNumber(number);
    }

    private static void printTopNumber(int number) {
        for (int i = 1; i <= number; i++) {
            String numAsStr = i + "";
            int[] nums = new int[numAsStr.length()];
            for (int j = 0; j < numAsStr.length(); j++) {
                nums[j] = Integer.parseInt(numAsStr.charAt(j)+"");
            }
            int sumDigits = 0;
            int countOdds = 0;
            for (int j = 0; j < nums.length; j++) {
                sumDigits += nums[j];
                if (nums[j] % 2 != 0) {
                    countOdds++;
                }
            }
            if ((sumDigits % 8 == 0) && countOdds >= 1)  {
                System.out.println(i);
            }
        }
    }
}
