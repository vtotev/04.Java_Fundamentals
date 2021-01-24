package RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\|");
        String regexCapitalLetters = "([#$%*&]{1})(?<letters>[A-Z]+)\\1";
        Pattern pattern = Pattern.compile(regexCapitalLetters);
        Matcher matcher = pattern.matcher(input[0]);
        String letters = "";
        if (matcher.find()) {
            letters = matcher.group("letters");
        }
        String regexASCIICoded = "(?<ascii>[0-9]{2})[:](?<length>[0-9]{2})";
        pattern = pattern.compile(regexASCIICoded);
        matcher = pattern.matcher(input[1]);
        Map<Integer, Integer> asciiCodes = new LinkedHashMap<>();
        while (matcher.find()) {
            int asciiCode = Integer.parseInt(matcher.group("ascii"));
            int length = Integer.parseInt(matcher.group("length"));
            for (int i = 0; i < letters.length(); i++) {
                int currChar = (int) letters.charAt(i);
                if (currChar == asciiCode && !asciiCodes.containsKey(asciiCode)) {
                    asciiCodes.put(asciiCode, length + 1);
                }
            }
        }
        String[] wordsList = input[2].split("\\s+");
        for (int i = 0; i < letters.length(); i++) {
            for (String word : wordsList) {
                if (word.charAt(0) == letters.charAt(i) && word.length() == asciiCodes.get((int) word.charAt(0))) {
                    System.out.println(word);
                }
            }
        }
    }
}
