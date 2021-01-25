package ExamPrep;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int initialEnergy = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int counter = 0;
        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (initialEnergy - distance >= 0) {
                initialEnergy -= distance;
                counter++;
                if (counter % 3 == 0) {
                    initialEnergy += counter;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", counter, initialEnergy);
                return;
            }
            input = scan.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d", counter, initialEnergy);
    }
}
