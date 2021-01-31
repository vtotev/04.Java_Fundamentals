package ExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> groceries = Arrays.stream(scan.nextLine().split("!")).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equals("Go Shopping!")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Urgent":
                    urgentItem(groceries, command[1]);
                    break;

                case "Unnecessary":
                    unnecessaryItem(groceries, command[1]);
                    break;

                case "Correct":
                    correctItem(groceries, command[1], command[2]);
                    break;

                case "Rearrange":
                    rearrangeItem(groceries, command[1]);
                    break;

            }

            input = scan.nextLine();
        }
        String output = "";
        for (int i = 0; i < groceries.size(); i++) {
            output += groceries.get(i);
            if (i < groceries.size()-1) {
                output += ", ";
            }
        }
        System.out.println(output);
    }

    private static void rearrangeItem(List<String> groceries, String item) {
        if (groceries.contains(item)) {
            groceries.remove(item);
            groceries.add(item);
        }
    }

    private static void correctItem(List<String> groceries, String oldItem, String newItem) {
        if (groceries.contains(oldItem)) {
            groceries.set(groceries.indexOf(oldItem), newItem);
        }
    }

    private static void unnecessaryItem(List<String> groceries, String item) {
        if (groceries.contains(item)) {
            groceries.remove(item);
        }
    }

    private static void urgentItem(List<String> groceries, String item) {
        if (!groceries.contains(item)) {
            groceries.add(0, item);
        }
    }
}
