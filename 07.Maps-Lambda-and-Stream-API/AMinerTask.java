package MapsLambdaStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            int value = Integer.parseInt(scan.nextLine());
            resources.putIfAbsent(input, 0);
            resources.put(input, resources.get(input)+value);
            input = scan.nextLine();
        }
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
