package Methods;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());
        int sum = addInt(num1, num2);
        int result = subtract(sum, num3);
        System.out.println(result);
    }

    private static int subtract(int sum, int num3) {
        return sum - num3;
    }

    private static int addInt(int num1, int num2) {
        return  num1 + num2;
    }
}
