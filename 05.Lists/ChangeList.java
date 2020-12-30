package Lists;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        while (true) {
            String input = scan.nextLine();

            if (input.toLowerCase().equals("end")) {
                break;
            }

            String[] command = input.split("\\s+");

            switch (command[0].toLowerCase()) {
                case "delete":
                    int valueDel = Integer.parseInt(command[1]);
                    while (numbers.contains(valueDel)){
                        numbers.remove(Integer.valueOf(valueDel));
                    }
                    break;

                case "insert":
                    int value = Integer.parseInt(command[1]);
                    int index = Integer.parseInt(command[2]);
                    if (index < numbers.size()) {
                        numbers.add(index, value);
                    }
                    break;

            }
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}