package Arrays;

import java.util.Scanner;

public class RevStringArr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputs = scan.nextLine().split(" ");
        for (int i = ((inputs.length-1)/2); i >= 0; i--) {
            String inpN = inputs[i];
            inputs[i] = inputs[inputs.length-i-1];
            inputs[inputs.length-i-1] = inpN;
        }
        for (int i = 0; i < inputs.length; i++) {

        System.out.print(inputs[i] + " ");
        }
    }
}
