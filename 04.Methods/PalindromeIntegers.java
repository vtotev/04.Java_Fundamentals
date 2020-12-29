package Methods;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.toLowerCase().equals("end")) {
            System.out.println(checkPalindrome(Integer.parseInt(input)));
            input = scan.nextLine();
        }
    }

    private static boolean checkPalindrome(int num) {
        int num2 = reverseInt(num);
        if (num == num2) {
            return true;
        } else return false;
    }

    private static int reverseInt(int num) {
        int reversed = 0;
        while(num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }
}
