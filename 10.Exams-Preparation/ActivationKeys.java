package ExamPrep;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rawKey = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Generate")) {
            String[] cmd = input.split(">>>");
            switch (cmd[0]) {
                case "Contains":
                    System.out.println(checkContains(rawKey, cmd[1]));
                    break;
                case "Flip":
                    rawKey = flipUpLow(cmd[1], rawKey, Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]));
                    System.out.println(rawKey);
                    break;
                case "Slice":
                    rawKey = sliceKey(rawKey, Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    System.out.println(rawKey);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", rawKey);
    }

    private static String sliceKey(String rawKey, int startIdx, int endIdx) {
        return rawKey.substring(0, startIdx) + rawKey.substring(endIdx, rawKey.length());
    }

    private static String flipUpLow(String UpperLower, String rawKey, int startIdx, int endIdx) {
        String output = "";
        switch (UpperLower) {
            case "Upper":
                output = rawKey.substring(0, startIdx) + rawKey.substring(startIdx, endIdx).toUpperCase() + rawKey.substring(endIdx, rawKey.length());
                break;
            case "Lower":
                output = rawKey.substring(0, startIdx) + rawKey.substring(startIdx, endIdx).toLowerCase() + rawKey.substring(endIdx , rawKey.length());
                break;
        }
        return output;
    }

    private static String checkContains(String rawKey, String textToCheck) {
        if (rawKey.contains(textToCheck)) {
            return String.format("%s contains %s", rawKey, textToCheck);
        }  else return "Substring not found!";
    }
}
