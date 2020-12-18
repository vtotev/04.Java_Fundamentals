package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numb = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == numb) {
                    System.out.printf("%d %d%n", arr[i], arr[j]);
                }
            }
        }
    }
}
