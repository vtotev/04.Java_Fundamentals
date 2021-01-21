package TextProcessing;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstInput = scan.nextLine();
        String secondInput = scan.nextLine();
        while (secondInput.contains(firstInput)) {
            secondInput = secondInput.replace(firstInput, "");
        }
        System.out.println(secondInput);
    }
}
