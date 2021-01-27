package ExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("@")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scan.nextLine();
        int cupidsPosition = 0;
        while (!input.equals("Love!")) {
            String[] command = input.split(" ");
            if (command[0].equals("Jump")) {
                int cupidToJump = Integer.parseInt(command[1]);
                cupidsPosition += cupidToJump;
                if (cupidsPosition >= numbers.size())
                    cupidsPosition = 0;

                int currValue = numbers.get(cupidsPosition);
                int newValue = currValue-2;
                if (currValue == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", cupidsPosition);
                } else {
                    if (newValue <= 0) {
                        newValue = 0;
                        System.out.printf("Place %d has Valentine's day.%n", cupidsPosition);
                    }
                    numbers.set(cupidsPosition, newValue);
                }
            }
            input = scan.nextLine();
        }
        int housesLeft = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 0) {
                housesLeft++;
            }
        }
        System.out.printf("Cupid's last position was %d.%n", cupidsPosition);
        if (housesLeft == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", housesLeft);
        }
    }
}
