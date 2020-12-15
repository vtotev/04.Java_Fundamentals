package DataTypesAndVars;
import java.util.Scanner;

public class snbl {
     public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int snowballSnow = scanner.nextInt();
            int snowballTime = scanner.nextInt();
            int snowballQuality = scanner.nextInt();
            long maxValue = Long.MAX_VALUE;
            String print = "";

            for (int i = 0; i < n ; i++) {
                long snowballValue = (long) Math.pow(((double)snowballSnow / snowballTime), snowballQuality);
                if (maxValue > snowballValue) {
                    maxValue = snowballValue;
                    print = snowballSnow + " : " + snowballTime + " = " + snowballValue + " (" + snowballQuality + ")";
                }
            }
            System.out.println(print);
        }
    }
