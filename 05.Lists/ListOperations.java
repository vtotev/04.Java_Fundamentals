package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        while (true) {
            String input = scan.nextLine();
            if (input.toLowerCase().equals("end")) {
                break;
            }
            String[] commands = input.split(" ");
            switch (commands[0].toLowerCase()) {
                case "add":
                    numbers.add(Integer.parseInt(commands[1]));
                    break;

                case "insert":
                    int indexIns = Integer.parseInt(commands[2]);
                    int valueIns = Integer.parseInt(commands[1]);
                    if (indexIns >= 0 && indexIns < numbers.size()) {
                        numbers.add(indexIns, valueIns);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "remove":
                    int indexRem = Integer.parseInt(commands[1]);
                    if (indexRem >= 0 && indexRem < numbers.size()) {
                        numbers.remove(indexRem);
                    } else {
                        System.out.println("Invalid index");
                    }

                    break;

                case "shift":
                    int count = Integer.parseInt(commands[2]);
                    switch (commands[1].toLowerCase()) {
                        case "left":
                            for (int i = 0; i < count; i++) {
                                numbers.add(numbers.get(0));
                                numbers.remove(0);
                            }
                            break;

                        case "right":
                            for (int i = 0; i < count; i++) {
                                int lastNum = numbers.get(numbers.size()-1);
                                numbers.remove(numbers.size()-1);
                                numbers.add(0, lastNum);
                            }
                            break;
                    }
                    break;

            }

        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
