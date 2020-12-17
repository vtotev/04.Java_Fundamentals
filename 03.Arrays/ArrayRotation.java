package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numbers[] = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            int firstN = numbers[0];
            for (int k = 1; k < numbers.length; k++) {
                numbers[k - 1] = numbers[k];
            }
            numbers[numbers.length-1] = firstN;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
