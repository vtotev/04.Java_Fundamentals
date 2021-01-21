package TextProcessing;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : input) {
            for (int i = 0; i < word.length(); i++) {
                sb.append(word);
            }
        }
        System.out.println(sb.toString());
    }
}
