package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "(U\\$)(?<name>[A-Z][a-z]{2,})\\1(P@\\$)(?<pwd>[A-Za-z]{5,}[0-9]+)\\3";
        int validInputs = 0;
        Pattern pattern = Pattern.compile(regex);
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n", matcher.group("name"), matcher.group("pwd"));
                validInputs++;
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.printf("Successful registrations: %d", validInputs);
    }
}
