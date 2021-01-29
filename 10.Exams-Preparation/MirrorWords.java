package ExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String textStr = scan.nextLine();
        List<String> wordsLeft = new ArrayList<>();
        List<String> wordsRight = new ArrayList<>();
//        String regex = "(@|#)([A-Za-z]*)\\1\\1([A-Za-z]*)\\1";
        String regex = "(@|#)(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textStr);
        while (matcher.find()) {
            String leftWord = matcher.group(2);
            String rightWord = matcher.group(3);
            wordsLeft.add(leftWord);
            wordsRight.add(rightWord);
        }
        List<String> output = new ArrayList<>();
        if (!wordsLeft.isEmpty()) {
            System.out.printf("%d word pairs found!%n", wordsLeft.size());
            for (int i = 0; i < wordsLeft.size(); i++) {
                StringBuilder rightWord = new StringBuilder();
                rightWord.append(wordsRight.get(i));
                rightWord.reverse();
                if (wordsLeft.get(i).equals(rightWord.toString())) {
                    output.add(wordsLeft.get(i) + " <=> " + wordsRight.get(i));
                }
            }
        } else System.out.println("No word pairs found!");
        if (!output.isEmpty()) {
            System.out.println("The mirror words are:");
            for (int i = 0; i < output.size(); i++) {
                System.out.print(output.get(i));
                if (i < output.size() - 1) {
                    System.out.print(", ");
                }
            }
        } else
            System.out.print("No mirror words!");
    }
}
