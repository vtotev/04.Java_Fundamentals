package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeckOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> vehiclesList = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            String[] cmd = scan.nextLine().split(", ");
            switch (cmd[0]) {
                case "Add":
                    int addIdx = checkIndex(vehiclesList, cmd[1]);
                    if (addIdx == -1) {
                        vehiclesList.add(cmd[1]);
                        System.out.println("Card successfully bought");
                    } else {
                        System.out.println("Card is already bought");
                    }
                    break;

                case "Remove":
                    int remIdx = checkIndex(vehiclesList, cmd[1]);
                    if (remIdx != -1) {
                        vehiclesList.remove(remIdx);
                        System.out.println("Card successfully sold");
                    } else {
                        System.out.println("Card not found");
                    }
                    break;

                case "Remove At":
                    int remAtIdx = Integer.parseInt(cmd[1]);
                    if (remAtIdx >= 0 && remAtIdx < vehiclesList.size()) {
                        vehiclesList.remove(remAtIdx);
                        System.out.println("Card successfully sold");
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;

                case "Insert":
                    int InsertIdx = Integer.parseInt(cmd[1]);
                    if (InsertIdx >= 0 && InsertIdx < vehiclesList.size()) {
                        int isExists = checkIndex(vehiclesList, cmd[2]);
                        if (isExists == -1) {
                            vehiclesList.add(InsertIdx, cmd[2]);
                            System.out.println("Card successfully bought");
                        } else {
                            System.out.println("Card is already bought");
                        }
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;

            }
        }
        System.out.println(String.join(", ", vehiclesList));
    }

    public static int checkIndex(List<String> list, String name) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(name)) {
                return i;
            }
        }
        return index;
    }

}
