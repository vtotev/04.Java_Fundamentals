package TextProcessing;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] keys = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scan.nextLine();
        while (!input.equals("find")) {
            String[] inputAsArr = input.split("");
            int z = 0;
            for (int i = 0; i < inputAsArr.length && z < keys.length; i++, z++) {
                inputAsArr[i] = (char)(inputAsArr[i].charAt(0) - keys[z])+"";
                if (z == keys.length - 1) {
                    z = -1;
                }
            }
            String output = "";
            for (int i = 0; i < inputAsArr.length; i++) {
                output += inputAsArr[i];
            }
            String type = output.substring(output.indexOf("&")+1, output.lastIndexOf("&"));
            String coordinates = output.substring(output.indexOf("<")+1, output.lastIndexOf(">"));
            System.out.printf("Found %s at %s%n", type, coordinates);
            input = scan.nextLine();
        }
    }
}
