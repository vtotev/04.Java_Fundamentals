package BasicExercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numb = Integer.parseInt(scan.nextLine());
        int length = String.valueOf(numb).length();

        int fact = 0;
        int factSum = 0;

        String numAsStr = String.valueOf(numb);
        for (int i = 1; i <= length; i++) {
            char smallN = numAsStr.charAt(i-1);
            int smallNumb = Integer.parseInt(String.valueOf(smallN));
            fact = 1;

            for (int y = 1; y < smallNumb; y++) {
                fact += fact * y;
            }
            factSum += fact;
        }
        if (numb == factSum)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
