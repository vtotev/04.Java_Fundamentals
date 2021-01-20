package TextProcessing;

import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."};
        String[] charSet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        String[] inputArr = scan.nextLine().split("\\|");
        String outputWord = "";
        for (int i = 0; i < inputArr.length; i++) {
            String[] word = inputArr[i].split(" ");
            for (int j = 0; j < word.length; j++) {
                for (int k = 0; k < code.length; k++) {
                    if (word[j].equals(code[k])) {
                        word[j] = charSet[k];
                    }
                }
                outputWord += word[j];
            }
            if (i < inputArr.length-1) {
                outputWord += " ";
            }
        }
        System.out.println(outputWord);
    }
}
