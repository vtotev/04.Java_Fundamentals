package BasicExercise;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int divby = 0;
        if (num % 2 == 0)  divby = 2;
        if (num % 3 == 0)  divby = 3;
        if (num % 6 == 0)  divby = 6;
        if (num % 7 == 0)  divby = 7;
        if (num % 10 == 0)  divby = 10;
        if (divby != 0)
          System.out.println("The number is divisible by "+divby);
        else System.out.println("Not divisible");
    }
}
