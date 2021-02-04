package FinalExam;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int unlikedCounter = 0;
        Map<String, List<String>> mealsList = new LinkedHashMap<>();
        while (!input.equals("Stop")) {
            String[] cmd = input.split("-");
            switch (cmd[0]) {
                case "Like":
                    if (!mealsList.containsKey(cmd[1])) {
                        mealsList.put(cmd[1], new ArrayList<>());
                    }
                    if (!mealsList.get(cmd[1]).contains(cmd[2])) {
                        mealsList.get(cmd[1]).add(cmd[2]);
                    }
                    break;
                case "Unlike":
                    if (mealsList.containsKey(cmd[1])) {
                        if (mealsList.get(cmd[1]).contains(cmd[2])) {
                            mealsList.get(cmd[1]).remove(cmd[2]);
                            unlikedCounter++;
                            System.out.printf("%s doesn't like the %s.%n", cmd[1], cmd[2]);
                        } else {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", cmd[1], cmd[2]);
                        }
                    } else {
                        System.out.printf("%s is not at the party.%n", cmd[1]);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        mealsList.entrySet().stream().sorted(new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> o1, Map.Entry<String, List<String>> o2) {
                int idx1 = o1.getValue().size();
                int idx2 = o2.getValue().size();
                if (idx2 - idx1 != 0) {
                    return idx2-idx1;
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        }).forEach(o -> System.out.printf("%s: %s%n", o.getKey(), String.join(", ", o.getValue())));
        System.out.printf("Unliked meals: %d%n", unlikedCounter);
    }
}
