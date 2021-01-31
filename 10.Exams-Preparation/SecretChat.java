package ExamPrep;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Reveal")) {
            String[] cmd = input.split(":\\|:");
            switch (cmd[0]) {
                case "InsertSpace":
                    int indx = Integer.parseInt(cmd[1]);
                    message = message.substring(0, indx) + " " + message.substring(indx, message.length());
                    System.out.println(message);
                    break;
                case "Reverse":
                    int revIdx = message.indexOf(cmd[1]);
                    if (revIdx != -1) {
                        StringBuilder str = new StringBuilder();
                        str.append(message.substring(revIdx, revIdx+cmd[1].length()));
                        str.reverse();
                        message = message.substring(0, revIdx) + message.substring(revIdx + cmd[1].length(), message.length())  + str.toString();
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    message = message.replaceAll(cmd[1], cmd[2]);
                    System.out.println(message);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }
}
