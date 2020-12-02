package BasicExercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lostGames = Integer.parseInt(scan.nextLine());

        double priceHeadset = Double.parseDouble(scan.nextLine());
        double priceMouse = Double.parseDouble(scan.nextLine());
        double priceKeyboard = Double.parseDouble(scan.nextLine());
        double priceDisplay = Double.parseDouble(scan.nextLine());

        double headset = Math.floor(lostGames / 2);
        double mouse = Math.floor(lostGames / 3);
        double keyb = Math.floor(lostGames / 6);
        double display = Math.floor(keyb / 2);

        double expenses = (headset * priceHeadset) + (mouse * priceMouse) + (keyb*priceKeyboard) + (display*priceDisplay);

        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}
