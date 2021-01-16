package MapsLambdaStreamAPI;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Integer>> dwarfs = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("Once upon a time")) {
            String[] cmd = input.split(" <:> ");
            String dwarfName = cmd[0];
            String dwarfHatColor = cmd[1];
            int dwarfPhysics = Integer.parseInt(cmd[2]);
            if (dwarfPhysics < 0) {
                continue;
            }
            if (!dwarfs.containsKey(dwarfHatColor)) {
                dwarfs.put(dwarfHatColor, new LinkedHashMap<>());
            }
            if (dwarfs.get(dwarfHatColor).containsKey(dwarfName)) {
                if (dwarfs.get(dwarfHatColor).get(dwarfName) < dwarfPhysics) {
                    dwarfs.get(dwarfHatColor).put(dwarfName, dwarfPhysics);
                }
            } else {
                dwarfs.get(dwarfHatColor).put(dwarfName, dwarfPhysics);
            }
            input = scan.nextLine();
        }
        Map<String, Integer> sorted = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, Integer>> entry : dwarfs.entrySet()) {
            for (Map.Entry<String, Integer> subEntry : dwarfs.get(entry.getKey()).entrySet()) {
                sorted.put(entry.getKey() + ", " + subEntry.getKey(), subEntry.getValue());
            }
        }
        sorted.entrySet().stream()
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        int compare = Integer.compare(o2.getValue(), o1.getValue());
                        if (compare != 0) {
                            return compare;
                        }
                        String[] values1 = o1.getKey().split(", ");
                        String[] values2 = o2.getKey().split(", ");

                        return Integer.compare(dwarfs.get(values2[0]).size(), dwarfs.get(values1[0]).size());
                    }
                })
                .forEach(d -> {
                    String[] splitted = d.getKey().split(", ");
                    String color = splitted[0];
                    String name = splitted[1];
                    System.out.printf("(%s) %s <-> %s%n", color, name, d.getValue());

                });
    }
}
