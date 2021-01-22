package TextProcessing;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] bannedWords = scan.nextLine().split(", ");
        String textToEdit = scan.nextLine();
        for (int i = 0; i < bannedWords.length; i++) {
            String replacementWord = "";
            for (int j = 0; j < bannedWords[i].length(); j++) {
                replacementWord += "*";
            }
            while (textToEdit.contains(bannedWords[i])) {
               textToEdit = textToEdit.replace(bannedWords[i], replacementWord);
            }
        }
        System.out.println(textToEdit);
    }
}
