package BasicExercise;

import java.util.Scanner;

public class TriangleofNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numb = Integer.parseInt(scan.nextLine());
        if (numb >= 1 && numb <= 20) {
            for (int i = 1; i <= numb; i++) {
                for (int y = 1; y <= i; y++) {
                    System.out.printf("%d ", i);
                }
                System.out.println();
            }
        }
    }
}
