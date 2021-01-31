package ExamPrep;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Done" )) {
            String[] cmd = input.split(" ");
            switch (cmd[0]) {
                case "TakeOdd":
                    password = TakeOdd(password);
                    System.out.println(password);
                    break;
                case "Cut":
                    password = CutPasword(password, Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substr1 = cmd[1];
                    String substr2 = cmd[2];
                    String newPassword = SubstitutePass(password, substr1, substr2);
                    if (newPassword.equals("Nothing to replace!")) {
                        System.out.println(newPassword);
                    } else {
                        password = newPassword;
                        System.out.println(password);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("Your password is: " + password);
    }

    private static String SubstitutePass(String password, String substr1, String substr2) {
        if (!password.contains(substr1)) {
            return "Nothing to replace!";
        }
        return password = password.replaceAll(substr1, substr2);
    }

    private static String CutPasword(String password, int startIdx, int endIdx) {
        String newPwd = password.substring(0, startIdx) + password.substring(startIdx+endIdx, password.length());
        return newPwd;
    }

    private static String TakeOdd(String password) {
        String newPassword = "";
        for (int i = 0; i < password.length(); i++) {
            if (i % 2 != 0) {
                newPassword += Character.toString(password.charAt(i));
            }
        }
        return newPassword;
    }
}
