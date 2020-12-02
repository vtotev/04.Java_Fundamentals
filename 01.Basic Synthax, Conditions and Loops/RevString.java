package BasicExercise;

import java.util.Scanner;

public class RevString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inp = scan.nextLine();

        StringBuilder userRev = new StringBuilder();
        userRev.append(inp);
        userRev.reverse();

        System.out.println(userRev);

    }
}
