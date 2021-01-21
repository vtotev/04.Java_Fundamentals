package TextProcessing;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("end")) {
            StringBuilder sb = new StringBuilder();
            sb.append(input);
            sb.reverse();
            System.out.printf("%s = %s%n", input, sb.toString());
            input = scan.nextLine();
        }
    }
}
