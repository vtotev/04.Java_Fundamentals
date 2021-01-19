package TextProcessing;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            output += (char)(input.charAt(i)+3);
        }
        System.out.println(output);
    }
}
