package TextProcessing;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int[] leftNums = new int[input[0].length()];
        int[] rightNums = new int[input[1].length()];
        for (int i = 0; i < input[0].length(); i++) {
            leftNums[i] = input[0].charAt(i);
        }
        for (int i = 0; i < input[1].length(); i++) {
            rightNums[i] = input[1].charAt(i);
        }
        int Sum = 0;
        if (leftNums.length >= rightNums.length) {
            for (int i = 0; i < rightNums.length; i++) {
                Sum += leftNums[i] * rightNums[i];
            }
            for (int i = rightNums.length; i < leftNums.length; i++) {
                Sum += leftNums[i];
            }
        } else {
            for (int i = 0; i < leftNums.length; i++) {
                Sum += leftNums[i] * rightNums[i];
            }
            for (int i = leftNums.length; i < rightNums.length; i++) {
                Sum += rightNums[i];
            }
        }

        System.out.println(Sum);
    }
}
