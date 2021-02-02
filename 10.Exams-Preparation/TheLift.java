package ExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scan.nextLine());
        int[] liftState = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int wagonSum = 0;
        for (int i = 0; i < liftState.length; i++) {
            while ((liftState[i] < 4) && peopleCount > 0) {
                liftState[i]++;
                peopleCount--;
            }
            wagonSum += liftState[i];
        }
        if (wagonSum < liftState.length * 4) {
            System.out.println("The lift has empty spots!");
        }
        if (peopleCount > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleCount);
        }
        for (int i = 0; i < liftState.length; i++) {
            System.out.print(liftState[i] + " ");
        }
    }
}
