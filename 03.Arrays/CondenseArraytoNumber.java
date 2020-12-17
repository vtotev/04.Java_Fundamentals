package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArraytoNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] condensed = new int[nums.length-1];
        for (int j = 0; j < condensed.length ; j++) {
            for (int i = 0; i < nums.length-1; i++) {
                condensed[i] = nums[i] + nums[i+1];
            }
            nums = condensed;
        }
        System.out.println(nums[0]);
    }
}
