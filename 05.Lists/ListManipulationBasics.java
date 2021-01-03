package Lists;

import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        while (true) {
            String input = scan.nextLine();
            if (input.toLowerCase().equals("end")) {
                break;
            }

            String[] command = input.split(" ");
            switch (command[0].toLowerCase()) {
                case "add":
                    numbers.add(Integer.parseInt(command[1]));
                    break;
                case "remove":
                    int numberToRemove = Integer.parseInt(command[1]);
                    numbers.remove((Object)numberToRemove);
                    break;
                case "removeat":
                    int index = Integer.parseInt(command[1]);
                    numbers.remove(index);
                    break;
                case "insert":
                    int numberToIns = Integer.parseInt(command[1]);
                    int indexToIns = Integer.parseInt(command[2]);
                    numbers.add(indexToIns, numberToIns);
                    break;
            }
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
