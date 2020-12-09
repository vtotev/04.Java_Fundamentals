package DataTypesAndVars;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        if (peopleCount <= capacity) {
            System.out.println("1");
        }
        else {
            if (peopleCount % capacity == 0) {
                System.out.println((peopleCount / capacity));
            } else
                System.out.println((peopleCount / capacity)+1);
        }
    }
}
