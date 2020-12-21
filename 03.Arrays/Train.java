package Arrays;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        int[] people = new int[count];
        String peopleToPrint = "";
        int sum = 0;
        for (int i = 0; i < count; i++) {
            people[i] = Integer.parseInt(scan.nextLine());
            sum += people[i];
            peopleToPrint += people[i] + " ";
        }
        System.out.println(peopleToPrint);
        System.out.println(sum);
    }
}
