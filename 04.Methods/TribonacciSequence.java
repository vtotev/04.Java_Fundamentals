package Methods;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        printTribonacci(count);
    }

    private static void printTribonacci(int count) {
        int[] arr = new int[count];
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                if (i == 0 || i == 1) {
                    arr[i] = 1;
                } else if (i == 2) {
                    arr[i] = arr[i-1] + arr[i-2];
                }
                else {
                    arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
