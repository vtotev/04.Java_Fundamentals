package ExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] targets = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input = scan.nextLine();
        int count = 0;
        while (!input.equals("End")) {
            int index = Integer.parseInt(input);
            if (index >= 0 && index < targets.length) {
                int currValue = targets[index];
                if (currValue != -1) {
                    targets[index] = -1;
                    count++;
                }
                for (int i = 0; i < targets.length; i++) {
                    if (targets[i] != -1) {
                        if (targets[i] > currValue) {
                            targets[i] -= currValue;
                        } else {
                            targets[i] += currValue;
                        }
                    }
                }
            }
            input = scan.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", count);
        for (int i = 0; i < targets.length; i++) {
            System.out.printf("%d ", targets[i]);
        }
    }
}
