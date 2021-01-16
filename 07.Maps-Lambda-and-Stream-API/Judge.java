package MapsLambdaStreamAPI;

import java.util.*;

public class Judge {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Integer>> contestsList = new LinkedHashMap();
        String input = scan.nextLine();
        while (!input.equals("no more time")) {
            String[] cmd = input.split(" -> ");
            String name = cmd[0];
            String contest = cmd[1];
            int points = Integer.parseInt(cmd[2]);
            if (!contestsList.containsKey(contest)) {
                contestsList.put(contest, new LinkedHashMap<>());
            }
            Map<String, Integer> studentList = contestsList.get(contest);
            if (studentList.containsKey(name)) {
                if (studentList.get(name) < points) {
                    studentList.put(name, points);
                }
            } else {
                studentList.put(name, points);
            }
            contestsList.put(contest, studentList);
            input = scan.nextLine();
        }
        var ref = new Object() {
            int idx = 1;
        };
        contestsList.entrySet().stream().forEach(c -> {
            System.out.printf("%s: %d participants%n", c.getKey(), c.getValue().entrySet().size());
            ref.idx = 1;
            c.getValue().entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    int intCompare = o2.getValue() - o1.getValue();
                    if (intCompare != 0) {
                        return intCompare;
                    }
                    return o1.getKey().compareTo(o2.getKey());
                }
            }).forEach(pr -> {
                System.out.println(ref.idx + ". " + pr.getKey() + " <::> " + pr.getValue());
                ref.idx++;
            });
        });
        Map<String, Integer> allCompetitors = new LinkedHashMap<>();
        contestsList.entrySet().stream().forEach(o -> o.getValue().entrySet().stream().forEach(e -> {
            int value = e.getValue();
            if (allCompetitors.containsKey(e.getKey())) {
                value += allCompetitors.get(e.getKey());
            }
            allCompetitors.put(e.getKey(), value);
        }));
        System.out.println("Individual standings:");
        ref.idx = 1;
        allCompetitors.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int intCompare = o2.getValue() - o1.getValue();
                if (intCompare != 0) {
                    return intCompare;
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        }).forEach(e -> {
            System.out.printf("%d. %s -> %d%n", ref.idx, e.getKey(), e.getValue());
            ref.idx++;
        });
    }
}
