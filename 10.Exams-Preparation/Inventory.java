package ExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> items = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equals("Craft!")) {
            String[] command = input.split(" - ");
            switch (command[0]) {
                case "Collect":
                    collectItem(items, command[1]);
                    break;
                case "Drop":
                    dropItem(items, command[1]);
                    break;
                case "Combine Items":
                    combineItems(items, command[1]);
                    break;
                case "Renew":
                    renewItem(items, command[1]);
                    break;
            }

            input = scan.nextLine();
        }
        String output = "";
        for (int i = 0; i < items.size(); i++) {
            output += items.get(i);
            if (i != items.size()-1) {
                output += ", ";
            }
        }
        System.out.println(output);
    }

    private static void renewItem(List<String> itemsList, String item) {
        if (itemsList.contains(item)) {
            itemsList.remove(itemsList.indexOf(item));
            itemsList.add(item);
        }
    }

    private static void combineItems(List<String> itemsList, String item) {
        String[] newItems = item.split(":");
        String oldItem = newItems[0];
        String newItem = newItems[1];
        if (itemsList.contains(oldItem)) {
            itemsList.add(itemsList.indexOf(oldItem)+1, newItem);
        }
    }

    private static void dropItem(List<String> itemsList, String item) {
        if (itemsList.contains(item)) {
            itemsList.remove(item);
        }
    }

    private static void collectItem(List<String> itemsList, String item) {
        if (!itemsList.contains(item)) {
            itemsList.add(item);
        }
    }
}
