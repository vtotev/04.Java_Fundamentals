package ExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] cmd = input.split("\\s+");
            int idx = Integer.parseInt(cmd[1]);
            switch (cmd[0]) {
                case "Shoot":
                    int power = Integer.parseInt(cmd[2]);
                    shootTarget(targets, idx, power);
                    break;
                case "Add":
                    int value = Integer.parseInt(cmd[2]);
                    addTarget(targets, idx, value);
                    break;
                case "Strike":
                    int radius = Integer.parseInt(cmd[2]);
                    strikeTarget(targets, idx, radius);
                    break;
            }

            input = scan.nextLine();
        }
        for (int i = 0; i < targets.size(); i++) {
            System.out.print(targets.get(i));
            if (i < targets.size() - 1) {
                System.out.print("|");
            }
        }
    }

    private static void strikeTarget(List<Integer> targets, int idx, int radius) {
        int firstIndx = idx - radius;
        int lastIndx = idx + radius;
        if (firstIndx >= 0 && lastIndx < targets.size()) {
            for (int i = firstIndx; i <= lastIndx; i++) {
                targets.remove(firstIndx);
            }
        } else {
            System.out.println("Strike missed!");
        }
    }

    private static void addTarget(List<Integer> targets, int idx, int value) {
        if (idx >= 0 && idx < targets.size()) {
            targets.add(idx, value);
        } else
            System.out.println("Invalid placement!");
    }

    private static void shootTarget(List<Integer> targets, int idx, int power) {
        if (idx >= 0 && idx < targets.size()) {
            targets.set(idx, targets.get(idx) - power);
            if (targets.get(idx) <= 0) {
                targets.remove(idx);
            }
        }
    }
}
