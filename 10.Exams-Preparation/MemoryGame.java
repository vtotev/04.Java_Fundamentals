package ExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> items = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String input = scan.nextLine();
        int turns = 0;
        while (!input.toLowerCase().equals("end")) {
            int[] indexes = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            turns++;
            if (indexes[0] >= 0 && indexes[1] >= 0 && indexes[0] < items.size() && indexes[1] < items.size()) {
                String item1 = items.get(indexes[0]);
                String item2 = items.get(indexes[1]);
                if (item1.equals(item2)) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n", item1);
                    if (indexes[0] > indexes[1]) {
                        items.remove(indexes[0]);
                        items.remove(indexes[1]);
                    } else {
                        items.remove(indexes[1]);
                        items.remove(indexes[0]);
                    }
                } else {
                    System.out.println("Try again!");
                }
                if (items.isEmpty()) {
                    System.out.printf("You have won in %d turns!%n", turns);
                    return;
                }
            } else {
                System.out.println("Invalid input! Adding additional elements to the board");
                int midIndx = items.size()/2;
                items.add(midIndx, "-"+turns+"a");
                items.add(midIndx, "-"+turns+"a");
            }
            input = scan.nextLine();
        }
        System.out.println("Sorry you lose :(");
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i) + " ");
        }
    }
}
