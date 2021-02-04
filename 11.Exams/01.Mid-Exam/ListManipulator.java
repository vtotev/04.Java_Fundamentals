package MidExam;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> friendsList = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String input = scan.nextLine();
        int countBlacklisted = 0;
        int countLost = 0;
        while (!input.equals("Report")) {
            String[] cmd = input.split(" ");
            switch (cmd[0]) {
                case "Blacklist":
                    int blacklistedIndex = getNameIndex(friendsList, cmd[1]);
                    if (blacklistedIndex != -1) {
                        friendsList.set(blacklistedIndex, "Blacklisted");
                        System.out.printf("%s was blacklisted.%n", cmd[1]);
                        countBlacklisted++;
                    } else {
                        System.out.printf("%s was not found.%n", cmd[1]);
                    }
                    break;

                case "Error":
                    int errIndex = Integer.parseInt(cmd[1]);
                    if (!friendsList.get(errIndex).equals("Blacklisted") && !friendsList.get(errIndex).equals("Lost")) {
                        System.out.printf("%s was lost due to an error.%n", friendsList.get(errIndex));
                        friendsList.set(errIndex, "Lost");
                        countLost++;
                    }
                    break;

                case "Change":
                    int changeIndex = Integer.parseInt(cmd[1]);
                    if (changeIndex >= 0 && changeIndex < friendsList.size()) {
                        System.out.printf("%s changed his username to %s.%n", friendsList.get(changeIndex), cmd[2]);
                        friendsList.set(changeIndex, cmd[2]);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n", countBlacklisted);
        System.out.printf("Lost names: %d%n", countLost);
        System.out.println(String.join(" ", friendsList));
    }

    public static int getNameIndex(List<String> list, String name) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(name)) {
                return i;
            }
        }
        return index;
    }
}
