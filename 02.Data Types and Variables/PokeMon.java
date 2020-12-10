package DataTypesAndVars;

import javax.naming.InitialContext;
import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        int initialN = N;
        int M = Integer.parseInt(scan.nextLine());
        short Y = Short.parseShort(scan.nextLine());
        short pokes = 0;
        while (N >= M) {
            N -= M;
            pokes++;
            if (Y > 0) {
                double percents = ((double) N / initialN) * 100;
                if (percents == 50) {
                    if (N / Y > 0)
                        N = N / Y;
                }
            }
        }
        System.out.println(N);
        System.out.println(pokes);
    }
}
