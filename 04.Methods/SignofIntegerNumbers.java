package Methods;

import java.util.Scanner;

public class SignofIntegerNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SignNum(Integer.parseInt(scan.nextLine()));
    }

    private static void SignNum(int number) {
        String result = "";
        if (number > 0) {
            result = "The number %d is positive.";
        } else if (number < 0) {
            result = "The number %d is negative.";
        } else
            result = "The number %d is zero.";

        System.out.printf(result, number);
    }
}
