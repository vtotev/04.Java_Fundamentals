package RegularExpressions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> racerList = new LinkedHashMap<>();
        String[] racers = scan.nextLine().split(",\\s+");
        for (String racer : racers) {
            racerList.putIfAbsent(racer, 0);
        }
        String input = scan.nextLine();
        String nameRegex = "(?<name>[A-Za-z])";
        String numbersRegex = "(?<digits>[0-9]+)";
        Pattern pattern = Pattern.compile(nameRegex);
        Pattern patternDist = Pattern.compile(numbersRegex);
        while (!input.equals("end of race")) {
            Matcher matcher = pattern.matcher(input);
            String racerName = "";
            while (matcher.find()) {
                racerName += matcher.group("name");
            }
            if (racerList.containsKey(racerName)) {
                int newDistance = racerList.get(racerName);
                String distance = "";
                Matcher matcherDist = patternDist.matcher(input);
                while (matcherDist.find()) {
                    distance += matcherDist.group("digits");
                }
                for (int i = 0; i < distance.length(); i++) {
                    newDistance += Integer.parseInt(distance.charAt(i) + "");
                }
                racerList.put(racerName, newDistance);
            }
            input = scan.nextLine();
        }
        var ref = new Object() {
            int num = 1;
        };
        racerList.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
                .limit(3).forEach(e -> {
                            String place = ref.num+"";
                            if (ref.num == 1) {
                                place += "st";
                            } else if (ref.num == 2) {
                                place += "nd";
                            } else if (ref.num == 3){
                                place += "rd";
                            }
                            System.out.printf("%s place: %s%n", place, e.getKey());
                            ref.num++;
                        }
                );
    }
}
