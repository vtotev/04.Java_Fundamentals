package BasicExercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        float priceOutFall = 39.99f;
        float priceCSGo = 15.99f;
        float priceZplinterZell = 19.99f;
        float priceHonored = 59.99f;
        float priceRoverWatch = 29.99f;
        float priceRoverWatchOrigins = 39.99f;

        float ballance = Float.parseFloat(scan.nextLine());
        float initialBallance = ballance;
        String input = scan.nextLine();

        while (!input.equals("Game Time")) {
            switch (input) {
                case "OutFall 4":
                    if ((ballance - priceOutFall) >= 0) {
                        System.out.println("Bought OutFall 4");
                        ballance -= priceOutFall;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;

                case "CS: OG":
                    if ((ballance - priceCSGo) >= 0) {
                        System.out.println("Bought CS: OG");
                        ballance -= priceCSGo;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;

                case "Zplinter Zell":
                    if ((ballance - priceZplinterZell) >= 0) {
                        System.out.println("Bought Zplinter Zell");
                        ballance -= priceZplinterZell;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;

                case "Honored 2":
                    if ((ballance - priceHonored) >= 0) {
                        System.out.println("Bought Honored 2");
                        ballance -= priceHonored;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;

                case "RoverWatch":
                    if ((ballance - priceRoverWatch) >= 0) {
                        System.out.println("Bought RoverWatch");
                        ballance -= priceRoverWatch;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;

                case "RoverWatch Origins Edition":
                    if ((ballance - priceRoverWatchOrigins) >= 0) {
                        System.out.println("Bought RoverWatch Origins Edition");
                        ballance -= priceRoverWatchOrigins;
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;

            }
            if (ballance <= 0) {
                break;
            }
            input = scan.nextLine();
        }
        if (ballance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", (initialBallance - ballance), ballance);
        } else
            System.out.println("Out of money!");
    }
}
