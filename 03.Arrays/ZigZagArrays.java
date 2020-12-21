package Arrays;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        int[] arr1 = new int[count];
        int[] arr2 = new int[count];
        for (int i = 0; i < count; i++) {
            if (i % 2 != 0) {
                arr1[i] = scan.nextInt();
                arr2[i] = scan.nextInt();
            } else {
                arr2[i] = scan.nextInt();
                arr1[i] = scan.nextInt();
            }
        }
        for (int k = 0; k < arr2.length; k++) {
            System.out.print(arr2[k] + " ");
        }
        System.out.println();
        for (int k = 0; k < arr1.length; k++) {
            System.out.print(arr1[k] + " ");
        }
    }
}
