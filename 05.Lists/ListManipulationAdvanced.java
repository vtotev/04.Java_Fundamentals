package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
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
                case "contains":
                    int numToCheck = Integer.parseInt(commands[1]);
                    if (numbers.contains(numToCheck))
                        System.out.println("Yes");
                    else System.out.println("No such number");
                    break;

                case "print":
                    switch (commands[1].toLowerCase()) {
                        case "even":
                            printEvenOdds("even", numbers);
                            break;
                        case "odd":
                            printEvenOdds("odd", numbers);
                            break;
                    }
                    break;

                case "get":
                    getSumOfNumbers(numbers);
                    break;

                case "filter":
                    filterNumbers(commands[1], Integer.parseInt(commands[2]), numbers);
                    break;
            }

        }
    }

    private static void filterNumbers(String operator, int numberToFilter, List<Integer> numbers) {
        switch (operator) {
            case "<":
                for (int i = 0; i < numbers.size(); i++) {
                    int numberFromArr = numbers.get(i);
                    if (numberFromArr < numberToFilter)
                        System.out.print(numberFromArr + " ");
                }
                break;

            case ">":
                for (int i = 0; i < numbers.size(); i++) {
                    int numberFromArr = numbers.get(i);
                    if (numberFromArr > numberToFilter)
                        System.out.print(numberFromArr + " ");
                }
                break;

            case ">=":
                for (int i = 0; i < numbers.size(); i++) {
                    int numberFromArr = numbers.get(i);
                    if (numberFromArr >= numberToFilter)
                        System.out.print(numberFromArr + " ");
                }
                break;

            case "<=":
                for (int i = 0; i < numbers.size(); i++) {
                    int numberFromArr = numbers.get(i);
                    if (numberFromArr <= numberToFilter)
                        System.out.print(numberFromArr + " ");
                }
                break;
        }
        System.out.println();
    }

    private static void getSumOfNumbers(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println(sum);
    }

    private static void printEvenOdds(String command, List<Integer> numbers) {
        switch (command.toLowerCase()) {
            case "even":
                for (int i = 0; i < numbers.size(); i++) {
                    int num = numbers.get(i);
                    if (num % 2 == 0) {
                        System.out.print(num + " ");
                    }
                }
                break;

            case "odd":
                for (int i = 0; i < numbers.size(); i++) {
                    int num = numbers.get(i);
                    if (num % 2 != 0) {
                        System.out.print(num + " ");
                    }
                }
                break;
        }
        System.out.println();
    }
}
