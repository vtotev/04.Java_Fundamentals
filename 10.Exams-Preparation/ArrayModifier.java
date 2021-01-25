package ExamPrep;

import java.awt.im.InputContext;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] cmd = input.split(" ");
            switch (cmd[0]) {
                case "swap":
                    int idx1 = Integer.parseInt(cmd[1]);
                    int idx2 = Integer.parseInt(cmd[2]);
                    swapArray(numbers, idx1, idx2);
                    break;
                case "multiply":
                    int idxM1 = Integer.parseInt(cmd[1]);
                    int idxM2 = Integer.parseInt(cmd[2]);
                    multiplyArray(numbers, idxM1, idxM2);
                    break;
                case "decrease":
                    decreaseArray(numbers);
                    break;
            }

            input = scan.nextLine();
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length-1) {
                System.out.print(", ");
            }
        }
    }

    private static void decreaseArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] -= 1;
        }
    }

    private static void multiplyArray(int[] numbers, int idxM1, int idxM2) {
        numbers[idxM1] = numbers[idxM1] * numbers[idxM2];
    }

    private static void swapArray(int[] numbers, int idx1, int idx2) {
        int oldNum = numbers[idx1];
        numbers[idx1] = numbers[idx2];
        numbers[idx2] = oldNum;
    }
}
