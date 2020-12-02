package BasicExercise;

import java.util.Scanner;

public class PrintandSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = Integer.parseInt(scan.nextLine());
        int last = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = first; i <= last; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println();
        System.out.println("Sum: " + sum);
    }
}
