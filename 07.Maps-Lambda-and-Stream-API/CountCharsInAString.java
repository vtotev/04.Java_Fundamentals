package MapsLambdaStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<Character, Integer> count = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                count.putIfAbsent(input.charAt(i), 0);
                count.put(input.charAt(i), count.get(input.charAt(i))+1);
            }
        }
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
