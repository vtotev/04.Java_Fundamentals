package DataTypesAndVars;

import java.util.Scanner;

public class DecryptingMessages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        int lines = Integer.parseInt(scan.nextLine());
        String msg = "";
        for (int i = 0; i < lines; i++) {
            String inp = scan.nextLine();
            char chr = inp.charAt(0);
            chr += key;
            msg = msg + chr;
        }
        System.out.println(msg);
    }
}
