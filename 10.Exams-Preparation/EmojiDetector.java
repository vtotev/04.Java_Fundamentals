package ExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        long coolThreshold = 1;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                coolThreshold *= Long.parseLong(String.valueOf(input.charAt(i)));
            }
        }
        System.out.println("Cool threshold: " + coolThreshold);
        List<String> validEmojis = new ArrayList<>();
        int count = isValidEmoji(input, validEmojis, coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", count);
        for (int i = 0; i < validEmojis.size(); i++) {
            System.out.println(validEmojis.get(i));
        }

    }

    private static int isValidEmoji(String input, List<String> output, long threshold) {
        Pattern pattern = Pattern.compile("(?<symbols>[:]{2}|[*]{2})(?<name>[A-Z][a-z]{2,})\\1");
        String[] items = input.split("\\s+");
        String item = "";
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            Matcher matcher = pattern.matcher(items[i]);
            while (matcher.find()) {
                count++;
                item = matcher.group("name");
                int sum = 0;
                for (int j = 0; j < item.length(); j++) {
                    char check = item.charAt(j);
                    if (Character.isLetter(check)) {
                        sum += check;
                    }
                }
                if (sum >= threshold) {
                    output.add(matcher.group(0));
                }
            }
        }
        return count;
    }
}