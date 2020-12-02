package BasicExercise;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstN = Integer.parseInt(scan.nextLine());
        int secondN = Integer.parseInt(scan.nextLine());
        int thirdN = Integer.parseInt(scan.nextLine());

        int a,b,c;
        a = 0;
        b = 0;
        c = 0;
        if (firstN >= secondN && firstN >= thirdN & secondN >= thirdN) {
            a = firstN;
            b = secondN;
            c = thirdN;
        }
        if (firstN >= secondN && firstN >= thirdN && secondN <= thirdN) {
            a = firstN;
            b = thirdN;
            c = secondN;
        }

        if (secondN >= firstN && secondN >= thirdN & firstN >= thirdN) {
            a = secondN;
            b = firstN;
            c = thirdN;
        }
        if (secondN >= firstN && secondN >= thirdN & firstN <= thirdN) {
            a = secondN;
            b = thirdN;
            c = firstN;
        }

        if (thirdN >= firstN && thirdN >= secondN & firstN >= secondN) {
            a = thirdN;
            b = firstN;
            c = secondN;
        }
        if (thirdN >= firstN && thirdN >= secondN & firstN <= secondN) {
            a = thirdN;
            b = secondN;
            c = firstN;
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
