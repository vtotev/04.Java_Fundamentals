package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numbers.length; i++) {
            int count = numbers.length-i-1;
            for (int k = i+1; k < numbers.length; k++) {
                if (numbers[i] > numbers[k]) {
                    count--;
                }
            }
            if (count <= 0) {
                System.out.print(numbers[i] + " ");
            }
        }
    }
}
