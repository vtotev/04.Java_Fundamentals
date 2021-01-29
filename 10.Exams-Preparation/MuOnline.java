package ExamPrep;

import java.net.Inet4Address;
import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        int health = 100;
        int bitcoins = 0;
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\|");
        for (int i = 0; i < input.length; i++) {
            String[] inputArr = input[i].split(" ");
            String command = inputArr[0];
            int number = Integer.parseInt(inputArr[1]);
            switch (command) {
                case "potion":
                    int difference = 0;
                    int oldHealth = health;
                    if (health + number > 100) {
                        health = 100;
                        difference = health - oldHealth;
                    } else {
                        health += number;
                        difference = number;
                    }
                    System.out.printf("You healed for %d hp.%n", difference);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    bitcoins += number;
                    System.out.printf("You found %d bitcoins.%n", number);
                    break;
                default:
                    health -= number;
                    if (health <= 0) {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d", i+1);
                        return;
                    } else {
                        System.out.printf("You slayed %s.%n", command);
                    }
                    break;
            }
        }
        System.out.printf("You've made it!%nBitcoins: %d%nHealth: %s", bitcoins, health);
    }
}
