package TextProcessing;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            String input = scan.nextLine();
            String name = input.substring(input.indexOf("@")+1, input.indexOf("|"));
            String age = input.substring(input.indexOf("#")+1, input.indexOf("*"));
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
