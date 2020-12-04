package BasicExercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double coinsTotal = 0.0;

        double priceNuts = 2.0;
        double priceWater = 0.7;
        double priceCrisps = 1.5;
        double priceSoda = 0.8;
        double priceCoke = 1.0;

        String input = scan.nextLine();
        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);
            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
                coinsTotal += coins;
            } else System.out.printf("Cannot accept %.2f%n", coins);
            input = scan.nextLine();
        }

        input = scan.nextLine();
        while (!input.equals("End")) {
            switch (input) {
                case "Nuts":
                    if (priceNuts <= coinsTotal) {
                        coinsTotal -= priceNuts;
                        System.out.println("Purchased Nuts");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (priceWater <= coinsTotal) {
                        coinsTotal -= priceWater;
                        System.out.println("Purchased Water");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (priceCrisps <= coinsTotal) {
                        coinsTotal -= priceCrisps;
                        System.out.println("Purchased Crisps");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (priceSoda <= coinsTotal) {
                        coinsTotal -= priceSoda;
                        System.out.println("Purchased Soda");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (priceCoke <= coinsTotal) {
                        coinsTotal -= priceCoke;
                        System.out.println("Purchased Coke");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Change: %.2f%n", coinsTotal);
    }
}
