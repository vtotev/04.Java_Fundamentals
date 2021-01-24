package RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "([$#^@])\\1{5,}";
        Pattern pattern = Pattern.compile(regex);
        String[] tickets = scan.nextLine().split(",\\s*");
        for (String ticket : tickets) {
            while (ticket.contains(" ")) {
                ticket = ticket.replace(" ", "");
            }
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }
            String leftPart = ticket.substring(0, 10);
            String rightPart = ticket.substring(10);
            Matcher matcher = pattern.matcher(leftPart);
            if (matcher.find()) {
                leftPart = matcher.group(0);
            } else {leftPart = " ";}
            matcher = pattern.matcher(rightPart);
            if (matcher.find()) {
                rightPart = matcher.group(0);
            }else {rightPart = ".";}
            int leftCount = leftPart.length();
            int rightCount = rightPart.length();
            if (leftPart.charAt(0) == rightPart.charAt(0)) {
                if (leftCount == 10 && rightCount == 10) {
                    System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", ticket, leftCount, leftPart.charAt(0));
                } else if (leftCount >= 6 && rightCount >= 6) {
                    System.out.printf("ticket \"%s\" - %d%s%n", ticket, Math.min(leftCount, rightCount), leftPart.charAt(0));
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }
            } else {
                System.out.printf("ticket \"%s\" - no match%n", ticket);
            }
        }
    }
}
