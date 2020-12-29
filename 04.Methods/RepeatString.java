package Methods;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int reps = Integer.parseInt(scan.nextLine());
        System.out.println(repeatString(input, reps));
    }

    private static String repeatString(String input, int reps) {
        String result = "";
        for (int i = 0; i < reps; i++) {
            result = result + input;
        }
        return result;
    }
}
