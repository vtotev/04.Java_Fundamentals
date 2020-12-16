package DataTypesAndVars;

import java.util.Scanner;

public class TriplesofLatinLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            for (int k = 0; k < count; k++) {
                for (int j = 0; j < count; j++) {
                    char a = (char)('a'+ i);
                    char b = (char)('a'+ k);
                    char c = (char)('a'+ j);
                    System.out.printf("%s%s%s%n", a, b, c);
                }
            }
        }
    }
}
