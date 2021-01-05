package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> passengers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxPassengers = Integer.parseInt(scan.nextLine());
        while (true) {
            String input = scan.nextLine();

            if (input.equals("end"))
                break;

            String[] command = input.split(" ");
            if (command[0].equals("Add")) {
                passengers.add(Integer.parseInt(command[1]));
            }
            else {
                for (int i = 0; i < passengers.size(); i++) {
                    int newPassengers = Integer.parseInt(command[0]);
                    int totalPassengers = passengers.get(i) + newPassengers;
                    if (totalPassengers <= maxPassengers) {
                        passengers.set(i, totalPassengers);
                        break;
                    }
                }
            }
        }
        System.out.println(passengers.toString().replaceAll("[\\[\\],]", ""));
    }
}
