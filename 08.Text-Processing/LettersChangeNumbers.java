package TextProcessing;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String alphabet = " abcdefghijklmnopqrstuvwxyz";
        String alphabetUpper = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] inputs = scan.nextLine().split("\\s+");
        double totalSum = 0.0;
        for (int i = 0; i < inputs.length; i++) {
            double sum = 0.0;
            int number = Integer.parseInt(inputs[i].substring(1, inputs[i].length()-1));
            String firstLetter = inputs[i].charAt(0)+"";
            String lastLetter = inputs[i].charAt(inputs[i].length()-1)+"";
            int firstLetterIndex = alphabet.indexOf(firstLetter.toLowerCase());
            int lastLetterIndex = alphabet.indexOf(lastLetter.toLowerCase());
            if (Character.isUpperCase(firstLetter.charAt(0))) {
                sum = (double)number / firstLetterIndex;
            } else {
                sum = (double)number * firstLetterIndex;
            }
            if (Character.isUpperCase(lastLetter.charAt(0))) {
                sum -= (double)lastLetterIndex;
            } else {
                sum += (double)lastLetterIndex;
            }
            totalSum += sum;
        }
        System.out.printf("%.2f%n", totalSum);
    }
}
