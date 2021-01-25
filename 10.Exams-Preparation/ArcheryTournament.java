package ExamPrep;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scan.nextLine().split("\\|")).map(Integer::parseInt).collect(Collectors.toList());
        int playerPoints = 0;
        String input = scan.nextLine();
        while (!input.equals("Game over")) {
            String[] cmd = input.split("@");
            int length = 0;
            int startIdx = -1;
            int targetValue = 0;
            switch (cmd[0]) {
                case "Shoot Left":
                    startIdx = Integer.parseInt(cmd[1]);
                    length = Integer.parseInt(cmd[2]);
                    if (startIdx >= 0 && startIdx < targets.size()) {
                        for (int i = 0; i < length; i++) {
                            startIdx--;
                            if (startIdx < 0) {
                                startIdx = targets.size() - 1;
                            }
                        }
                        targetValue = targets.get(startIdx);
                        if (targetValue < 5) {
                            targets.remove(startIdx);
                            playerPoints += targetValue;
                        } else if (targetValue == 0) {
                            break;
                        } else {
                            targets.set(startIdx, targetValue - 5);
                            playerPoints += 5;
                        }
                    }
                    break;

                case "Shoot Right":
                    startIdx = Integer.parseInt(cmd[1]);
                    length = Integer.parseInt(cmd[2]);
                    if (startIdx >= 0 && startIdx < targets.size()) {
                        startIdx += length;
                        while (startIdx >= targets.size()) {
                            startIdx -= targets.size();
                        }
                        targetValue = targets.get(startIdx);
                        if (targetValue < 5) {
                            targets.set(startIdx, 0);
                            playerPoints += targetValue;
                        } else if (targetValue == 0) {
                            break;
                        } else {
                            targets.set(startIdx, targetValue - 5);
                            playerPoints += 5;
                        }
                    }
                    break;

                case "Reverse":
                    Collections.reverse(targets);
                    break;
            }
            input = scan.nextLine();
        }
        String output = targets.toString().replaceAll("[\\[\\],]", "");
        output = output.replaceAll(" ", " - ");
        System.out.println(output);
        System.out.printf("Iskren finished the archery tournament with %d points!", playerPoints);
    }
}
