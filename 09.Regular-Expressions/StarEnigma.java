package RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "[starSTAR]";
        String decRegex = "@(?<planet>[A-Za-z]+)[^@\\-!:>]*?\\:(?<population>\\d+)![^@\\-!:>]*?(?<type>[A|D])[^@\\-!:>]*?![^@\\-!:>]*?->(?<count>\\d+)";
        Map<String, List<String>> planets = new LinkedHashMap<>();
        Pattern patt = Pattern.compile(regex);
        Pattern pattern2 = Pattern.compile(decRegex);
        planets.put("A", new ArrayList<>());
        planets.put("D", new ArrayList<>());
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            String input = scan.nextLine();
            Matcher matcher = patt.matcher(input);
            String lettersCount = "";
            while (matcher.find()) {
                lettersCount += matcher.group(0);
            }
            String output = "";
            for (int j = 0; j < input.length(); j++) {
                char newChar = (char) (input.charAt(j) - lettersCount.length());
                output += newChar;
            }
            Matcher matcher2 = pattern2.matcher(output);
            while (matcher2.find()) {
                String planet = matcher2.group("planet");
                String attackType = matcher2.group("type");
                planets.get(attackType).add(planet);
            }
        }
        planets.entrySet().stream().forEach(o -> {
            if (o.getKey().equals("A")) {
                System.out.printf("Attacked planets: %d%n", o.getValue().stream().count());
            } else if (o.getKey().equals("D")) {
                System.out.printf("Destroyed planets: %d%n", o.getValue().stream().count());
            }
            o.getValue().stream().sorted().forEach(pl -> System.out.printf("-> %s%n", pl));
        });
    }
}
