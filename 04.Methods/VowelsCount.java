package Methods;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        vowelsCount(input);
    }

    private static void vowelsCount(String input) {
        String vowels = "aeiouAEIOU";
        int vowelsCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (vowels.contains(input.charAt(i)+""))
                vowelsCount++;
        }
        System.out.println(vowelsCount);
    }
}
