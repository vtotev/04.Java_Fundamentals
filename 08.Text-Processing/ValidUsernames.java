package TextProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] userNames = scan.nextLine().split(", ");
        String toPrint = "";
        List<String> validUsers = new ArrayList<>();
        for (int i = 0; i < userNames.length; i++) {
            if (userNames[i].length() >= 3 && userNames[i].length() <= 16) {
                String name = userNames[i];
                int invalidChars = 0;
                for (int j = 0; j < name.length(); j++) {
                    if (Character.isLetter(name.charAt(j)) || Character.isDigit(name.charAt(j)) || (name.charAt(j) == '-')
                            || (name.charAt(j) == '_') ) {
                    } else {
                        invalidChars++;
                    }
                }
                if (invalidChars == 0) {
                    validUsers.add(name);
                }
            }
        }
        for (int i = 0; i < validUsers.size(); i++) {
            System.out.println(validUsers.get(i));
        }
    }
}
