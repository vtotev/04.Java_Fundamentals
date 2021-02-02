package ExamPrep;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputStr = scan.nextLine();
        String command = scan.nextLine();
        while (!command.toLowerCase().equals("decode")) {
            String[] cmd = command.split("\\|");
            switch (cmd[0]) {
                case "Move":
                    int lettersCount = Integer.parseInt(cmd[1]);
                    inputStr = inputStr.substring(lettersCount, inputStr.length()) + inputStr.substring(0, lettersCount);
                    break;
                case "Insert":
                    int insIndx = Integer.parseInt(cmd[1]);
                    inputStr = inputStr.substring(0, insIndx) + cmd[2] + inputStr.substring(insIndx, inputStr.length());
                    break;
                case "ChangeAll":
                    while (inputStr.contains(cmd[1]))
                        inputStr = inputStr.replace(cmd[1], cmd[2]);
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println("The decrypted message is: " + inputStr);
    }
}
