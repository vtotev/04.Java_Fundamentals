package Methods;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());
        System.out.println(checkSign(num1, num2, num3));
    }

    private static String checkSign(int num1, int num2, int num3) {
        if (num1 == 0 || num2 == 0 || num3 == 0) {
            return "zero";
        } else if ((num1 < 0 || num2 < 0 || num3 < 0)) {
            int negatives = checkNegativesCoung(num1, num2, num3);
            if (negatives > 0 && (negatives % 2 != 0))
                return "negative";
            else
                return "positive";
        } else
            return "positive";
    }

    private static int checkNegativesCoung(int num1, int num2, int num3) {
        int[] nums = {num1, num2, num3};
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                counter++;
            }
        }
        return counter;
    }
}
