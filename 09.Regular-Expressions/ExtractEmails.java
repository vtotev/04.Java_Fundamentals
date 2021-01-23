package RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "\\b(?<user>[A-Za-z]+[A-Za-z-_.]*)[@]{1}(?<host>[A-Za-z-]+[.][A-Za-z]+[.]*[A-Za-z]*)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scan.nextLine());
        List<String> mails = new ArrayList<>();
        while (matcher.find()) {
            mails.add(matcher.group(0));
        }
        mails.stream().forEach(o -> System.out.println(o));
    }
}
