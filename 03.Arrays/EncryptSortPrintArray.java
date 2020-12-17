package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortPrintArray {
    public static void main(String[] args) {
        String vowels = "aeiouAEIOU";

        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
            names[i] = scan.nextLine();
        }
        int[] codes = new int[count];

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < names[i].length(); j++) {
                if (vowels.contains(names[i].charAt(j)+"")) {
                    codes[i] += ((int) names[i].charAt(j) * names[i].length());
                } else
                    codes[i] += ((int) names[i].charAt(j) / names[i].length());
            }
        }
        Arrays.sort(codes);
        for (int i = 0; i < count; i++) {
            System.out.println(codes[i]);

        }
    }
}