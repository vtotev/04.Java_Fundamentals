package ExamPrep;

import java.util.Scanner;

public class DisneylandJourney {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double journeyCost = Double.parseDouble(scan.nextLine());
        int monthsToCollect = Integer.parseInt(scan.nextLine());
        double monthlySave = journeyCost * 0.25;
        double moneyCollected = 0.0;
        for (int i = 1; i <= monthsToCollect; i++) {
            if (i % 4 == 0) {
                moneyCollected *= 1.25;
            }
            if (i > 1 && i % 2 != 0) {
                moneyCollected = (moneyCollected * 0.84);
            }
            moneyCollected += monthlySave;
        }
        if (moneyCollected >= journeyCost) {
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.%n",
                    (moneyCollected - journeyCost));
        } else {
            System.out.printf("Sorry. You need %.2flv. more.%n", journeyCost - moneyCollected);
        }
    }
}
