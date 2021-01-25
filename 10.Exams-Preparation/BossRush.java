package ExamPrep;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        String regex = "(\\|)(([A-Z]+){4})\\1:#([A-Za-z]+ [A-Za-z]+)#";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < count; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.printf("%s, The %s%n>> Strength: %d%n>> Armour: %d%n", matcher.group(2), matcher.group(4),
                        matcher.group(2).length(), matcher.group(4).length());
            }
            else {
                System.out.println("Access denied!");
            }
        }
    }
}
