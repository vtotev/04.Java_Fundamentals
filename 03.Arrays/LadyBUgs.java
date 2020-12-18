package Arrays;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.Scanner;

public class LadyBUgs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scan.nextLine());
        int[] field = new int[fieldSize];

        int[] bugIndexes = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < bugIndexes.length; i++) {
            int bugIdx = bugIndexes[i];
            if (bugIdx >= 0 && bugIdx < field.length)
                field[bugIdx] = 1;
        }

        String input = scan.nextLine();
        while (!input.equals("end")) {
            String cmds[] = input.split(" ");
            int bugIdx = Integer.parseInt(cmds[0]);
            String bugDirection = cmds[1];
            int bugFlyLength = Integer.parseInt(cmds[2]);

            if (bugIdx < 0 || bugIdx >= field.length || field[bugIdx] != 1) {
                input = scan.nextLine();
                continue;
            }

            field[bugIdx] = 0;

            if (bugDirection.equals("right")) {
                bugIdx += bugFlyLength;
                while (bugIdx < field.length && field[bugIdx] == 1) {
                    bugIdx += bugFlyLength;
                }
                if (bugIdx < field.length) {
                    field[bugIdx] = 1;
                }
            } else {
                bugIdx -= bugFlyLength;
                while (bugIdx >= 0 && field[bugIdx] == 1) {
                    bugIdx -= bugFlyLength;
                }
                if (bugIdx >= 0) {
                    field[bugIdx] = 1;
                }
            }

            input = scan.nextLine();
        }
        for (int i = 0; i < field.length; i++) {
            System.out.print(field[i] + " ");
        }
    }
}
