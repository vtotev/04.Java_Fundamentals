package DataTypesAndVars;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        double maxsnowballValue = 0.0;
        short maxsnowballSnow = 0;
        short maxsnowballTime = 0;
        short maxsnowballQuality = 0;
        if (N >= 0 && N <= 100) {
            for (short i = 0; i < N; i++) {
                short snowballSnow = Short.parseShort(scan.nextLine());
                short snowballTime = Short.parseShort(scan.nextLine());
                short snowballQuality = Short.parseShort(scan.nextLine());
                if (snowballSnow >= 0 && snowballTime > 0 && snowballQuality >= 0) {
                    double snowballValue = Math.pow((snowballSnow / snowballTime), snowballQuality);
                    if (snowballValue > maxsnowballValue) {
                        maxsnowballValue = snowballValue;
                        maxsnowballSnow = snowballSnow;
                        maxsnowballTime = snowballTime;
                        maxsnowballQuality = snowballQuality;
                    }
                }
            }
            System.out.printf("%d : %d = %.0f (%d)%n", maxsnowballSnow, maxsnowballTime, maxsnowballValue, maxsnowballQuality);
        }
    }
}
