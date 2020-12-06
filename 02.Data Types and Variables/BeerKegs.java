package DataTypesAndVars;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        String biggestKeg = "";
        double kegVol = 0.0;
        for (int i = 0; i < count; i++) {
            String kegName = scan.nextLine();
            double kegRadius = Double.parseDouble(scan.nextLine());
            int kegHeight = Integer.parseInt(scan.nextLine());
            double currKegVol = Math.PI * Math.pow(kegRadius, 2) * kegHeight;
            if (currKegVol > kegVol) {
                kegVol  = currKegVol;
                biggestKeg = kegName;
            }
        }
        System.out.println(biggestKeg);
    }
}
