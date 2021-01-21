package TextProcessing;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String output = input.charAt(0)+"";
        for (int i = 1; i < input.length(); i++) {
            //System.out.println(input.charAt(i));
            if (input.charAt(i-1) != input.charAt(i)) {
                output += (char) input.charAt(i);
            }
        }
        System.out.println(output);
    }
}
