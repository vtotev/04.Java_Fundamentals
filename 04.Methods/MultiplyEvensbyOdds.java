package Methods;

import java.util.Arrays;
import java.util.Scanner;

public class MultiplyEvensbyOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int digits = Integer.parseInt(scan.nextLine());
        System.out.println(getMultipleOfEvensAndOdds(digits));
    }

    private static int getMultipleOfEvensAndOdds(int digits) {
        int evenSums = getSumsOfEvenDigits(digits);
        int oddSums = getSumsOfOddDigits(digits);
        return evenSums * oddSums;
    }

    private static int getSumsOfEvenDigits(int digits) {
        digits = Math.abs(digits);
        String chars = "" + digits;
        int[] evenArr = Arrays.stream(chars.split("")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i = 0; i < evenArr.length; i++) {
            if (evenArr[i] % 2 == 0) {
                sum += evenArr[i];
            }
        }
        return sum;
    }

    private static int getSumsOfOddDigits(int digits) {
        digits = Math.abs(digits);
        String chars = "" + digits;
        int[] oddArr = Arrays.stream(chars.split("")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i = 0; i < oddArr.length; i++) {
            if (oddArr[i] % 2 != 0) {
                sum += oddArr[i];
            }
        }
        return sum;
    }
}
