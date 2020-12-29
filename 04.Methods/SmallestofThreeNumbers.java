package Methods;

import java.util.Scanner;

public class SmallestofThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());
        System.out.println(printSmallestNum(num1, num2, num3));
    }

    private static int printSmallestNum(int num1, int num2, int num3) {
        int result = 0;
        if (num1 <= num2 && num1 <= num3) {
            result = num1;
        }
        if (num2 <= num1 && num2 <= num3) {
            result = num2;
        }
        if (num3 <= num1 && num3 <= num2) {
            result = num3;
        }
        return result;
    }
}
