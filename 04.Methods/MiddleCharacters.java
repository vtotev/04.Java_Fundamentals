package Methods;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(getMiddleChar(input));
    }

    private static String getMiddleChar(String input) {
        if (input.length() % 2 == 0) {
            return input.charAt(input.length()/2-1)+""+input.charAt(input.length()/2);
        } else return input.charAt(input.length()/2)+"";
    }
}
