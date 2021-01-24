package RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "(?<word>[^\\d]+)(?<digit>[\\d]+)";
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder outputB = new StringBuilder();
        Map<Character, Integer> uniques = new LinkedHashMap<>();
        while (matcher.find()) {
            String word = matcher.group("word");
            int count = Integer.parseInt(matcher.group("digit"));
            for (int i = 0; i < count; i++) {
                outputB.append(word.toUpperCase());
            }
        }
        String output = outputB.toString();
        for (int i = 0; i < output.length(); i++) {
            char currChar = output.charAt(i);
            if (!uniques.containsKey(currChar)) {
                uniques.put(currChar, 0);
            }
        }
        System.out.printf("Unique symbols used: %d%n%s%n", uniques.size(), output);
    }
}
