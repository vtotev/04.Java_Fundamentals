package TextProcessing;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char firstChar = scan.nextLine().charAt(0);
        char lastChar = scan.nextLine().charAt(0);
        String randomString = scan.nextLine();
        int sum = 0;
        for (int i = 0; i < randomString.length(); i++) {
            if ((int)randomString.charAt(i) > (int)firstChar && (int)randomString.charAt(i) < (int)lastChar) {
                sum += (int)randomString.charAt(i);
            }
        }
        System.out.println(sum);
    }
}
