package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceofEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int longestNum = 0;
        int longestNumCount = 0;
        int longestNumCountCompare = 0;
        for (int i = 0; i < numbers.length; i++) {
            longestNumCount = 0;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    longestNumCount++;
                } else break;
            }
            if (longestNumCount > longestNumCountCompare) {
                longestNum = numbers[i];
                longestNumCountCompare = longestNumCount;
            }
        }
        for (int i = 0; i <= longestNumCountCompare; i++) {
            System.out.print(longestNum + " ");
        }
    }
}
