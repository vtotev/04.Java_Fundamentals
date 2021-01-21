package TextProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Character> output = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            output.add(symbol);
            if (symbol == '>') {
                i++;
                int bomb = input.charAt(i) - '0';
                int z;
                for (z = i; z < i + bomb && z < input.length(); z++) {
                    if (input.charAt(z) == '>') {
                        output.add('>');
                        z++;
                        bomb += (input.charAt(z) - '0') + 1;
                    }
                }
                i = z - 1;
            }
        }
        for (int i = 0; i < output.size() ; i++) {
            System.out.print(output.get(i));
        }
    }
}