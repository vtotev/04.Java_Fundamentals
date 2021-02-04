package FinalExam;

import java.util.Locale;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Sign up")) {
            String[] cmd = input.split(" ");
            switch (cmd[0]) {
                case "Case":
                    if (cmd[1].equals("lower")) {
                        name = name.toLowerCase();
                    } else if (cmd[1].equals("upper")) {
                        name = name.toUpperCase();
                    }
                    System.out.println(name);
                    break;
                case "Reverse":
                    int startIdx = Integer.parseInt(cmd[1]);
                    int endIdx = Integer.parseInt(cmd[2]);
                    if ((startIdx >= 0 && startIdx < name.length()) && (endIdx >= 0 && endIdx < name.length())) {
                        StringBuilder rev = new StringBuilder();
                        rev.append(name.substring(startIdx, endIdx+1));
                        rev.reverse();
                        System.out.println(rev);
                    }
                    break;
                case "Cut":
                    if (name.contains(cmd[1])) {
                        name = name.substring(0, name.indexOf(cmd[1])) + name.substring(name.indexOf(cmd[1])+cmd[1].length());
                        System.out.println(name);
                    } else {
                        System.out.printf("The word %s doesn't contain %s.%n", name, cmd[1]);
                    }
                    break;
                case "Replace":
                    while (name.contains(cmd[1])) {
                        name = name.replace(cmd[1], "*");
                    }
                    System.out.println(name);
                    break;
                case "Check":
                    if (name.contains(cmd[1])) {
                        System.out.println("Valid");
                    } else {
                        System.out.printf("Your username must contain %s.%n", cmd[1]);
                    }
                    break;
            }

            input = scan.nextLine();
        }
    }
}
