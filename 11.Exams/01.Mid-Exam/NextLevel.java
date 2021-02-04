package MidExam;

import java.util.Scanner;

public class NextLevel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int expNeeded = Integer.parseInt(scan.nextLine());
        int battleCount = Integer.parseInt(scan.nextLine());
        double expGained = 0.0;
        for (int i = 1; i <= battleCount; i++) {
            double bonus = 0;
            int input = Integer.parseInt(scan.nextLine());
            if (i % 3 == 0) {
                bonus = 15;
            }
            if (i % 5 == 0) {
                bonus = -10;
            }
            if (i % 15 == 0) {
                bonus += 5;
            }
            expGained += input + (input * (bonus/100));
            if (expGained >= expNeeded) {
                System.out.printf("Player successfully collected his needed experience for %d battles.", i);
                return;
            }
        }
        System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", expNeeded-expGained);
    }
}
