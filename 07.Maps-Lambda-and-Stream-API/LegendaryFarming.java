package MapsLambdaStreamAPI;

import java.util.*;

public class LegendaryFarming {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> quantity = new LinkedHashMap<>();
        quantity.putIfAbsent("shards", 0);
        quantity.putIfAbsent("fragments", 0);
        quantity.putIfAbsent("motes", 0);
        boolean isObtained = false;
        while (!isObtained) {
            String[] cmd = scan.nextLine().split(" ");
            for (int i = 1; i < cmd.length; i += 2) {
                String key = cmd[i].toLowerCase();
                quantity.putIfAbsent(key, 0);
                quantity.put(key, quantity.get(key) + Integer.parseInt(cmd[i - 1]));
                for (Map.Entry<String, Integer> entry : quantity.entrySet()) {
                    if (entry.getValue() >= 250) {
                        switch (entry.getKey()) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                entry.setValue(entry.getValue() - 250);
                                isObtained = true;
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                entry.setValue(entry.getValue() - 250);
                                isObtained = true;
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                entry.setValue(entry.getValue() - 250);
                                isObtained = true;
                                break;
                        }
                        break;
                    }
                }
                if (isObtained) break;
            }
        }
        quantity.entrySet().stream().sorted((o1, o2) -> {
            int q = Integer.compare(o2.getValue(), o1.getValue());
            if (q != 0) {
                return q;
            }
            return o1.getKey().compareTo(o2.getKey());
        })
                .filter(o -> o.getKey().equals("fragments") | o.getKey().equals("shards") | o.getKey().equals("motes"))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        quantity.entrySet().stream()
                .filter(o -> !o.getKey().equals("fragments") && !o.getKey().equals("shards") && !o.getKey().equals("motes"))
                .sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }
}
