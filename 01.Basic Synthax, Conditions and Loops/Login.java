package BasicExercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        String pass = scan.nextLine();

        StringBuilder userRev = new StringBuilder();
        userRev.append(user);
        userRev.reverse();

        int countTries = 1;
        while (!pass.equals(userRev.toString())) {
            if (countTries >= 4) {
                System.out.printf("User %s blocked!", user);
                break;
            }
            if (!pass.equals(userRev.toString())) {
                System.out.println("Incorrect password. Try again.");
                pass = scan.nextLine();
            }
            countTries++;
        }
        if (pass.equals(userRev.toString()) && countTries <= 4) {
            System.out.printf("User %s logged in.", user);
        }
    }
}
