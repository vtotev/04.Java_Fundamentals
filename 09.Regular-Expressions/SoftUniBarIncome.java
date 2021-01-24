package RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = "^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<products>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)[$]$";
        Pattern pattern = Pattern.compile(regex);
        double orderSum = 0.0;
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String orderName = matcher.group("name");
                String productName = matcher.group("products");
                int quantity = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                orderSum += quantity * price;
                System.out.printf("%s: %s - %.2f%n", orderName, productName, (quantity * price));
            }
            input = scan.nextLine();
        }
        System.out.printf("Total income: %.2f", orderSum);
    }
}
