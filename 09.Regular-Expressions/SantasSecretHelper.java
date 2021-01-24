package RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numToSubtract = Integer.parseInt(scan.nextLine());
        List<String> goodKids = new ArrayList<>();
        String regex = "[@](?<name>[A-Za-z]+)[^@\\-!:>]+[!](?<behave>[A-Z])[!]";
        Pattern pattern = Pattern.compile(regex);
        String input = scan.nextLine();
        while (!input.equals("end")) {
            StringBuilder editedInput = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char newChar = (char)((int)input.charAt(i) - numToSubtract);
                editedInput.append(newChar);
            }
            Matcher matcher = pattern.matcher(editedInput);
            while (matcher.find()) {
                if (matcher.group("behave").equals("G")) {
                    goodKids.add(matcher.group("name"));
                }
            }
            input = scan.nextLine();
        }
        goodKids.stream().forEach(System.out::println);
    }
}
