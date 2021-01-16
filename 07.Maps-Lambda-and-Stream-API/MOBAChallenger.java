package MapsLambdaStreamAPI;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Map<String, Integer>> playerList = new LinkedHashMap<>();
        while (!input.equals("Season end")) {
            if (input.contains("->")) {
                String[] cmd = input.split(" -> ");
                String playerName = cmd[0];
                String playerPosition = cmd[1];
                int playerSkill = Integer.parseInt(cmd[2]);
                if (!playerList.containsKey(playerName)) {
                    playerList.put(playerName, new LinkedHashMap<>());
                }
                if (!playerList.get(playerName).containsKey(playerPosition)) {
                    playerList.get(playerName).put(playerPosition, playerSkill);
                } else {
                    if (playerList.get(playerName).get(playerPosition) < playerSkill) {
                        playerList.get(playerName).put(playerPosition, playerSkill);
                    }
                }
            } else if (input.contains(" vs ")) {
                String[] cmd = input.split(" vs ");
                if (playerList.containsKey(cmd[0]) && playerList.containsKey(cmd[1])) {
                    String player1Key = "";
                    String player2Key = "";
                    for (Map.Entry<String, Integer> entry : playerList.get(cmd[0]).entrySet()) {
                        for (Map.Entry<String, Integer> entry2 : playerList.get(cmd[1]).entrySet()) {
                            if (entry.getKey().equals(entry2.getKey())) {
                                player1Key = entry.getKey();
                                player2Key = entry2.getKey();
                                break;
                            }
                        }
                    }
                    if (!player1Key.equals("") && !player2Key.equals("")) {
                        if (playerList.get(cmd[0]).get(player1Key) > playerList.get(cmd[1]).get(player2Key)) {
                            playerList.remove(cmd[1]);
                        } else if (playerList.get(cmd[0]).get(player1Key) < playerList.get(cmd[1]).get(player2Key)) {
                            playerList.remove(cmd[0]);
                        }
                    }
                }
            }
            input = scan.nextLine();
        }
        playerList.entrySet().stream()
                .sorted(new Comparator<Map.Entry<String, Map<String, Integer>>>() {
                    @Override
                    public int compare(Map.Entry<String, Map<String, Integer>> o1, Map.Entry<String, Map<String, Integer>> o2) {
                        double avg1 = 0.0;
                        for (Map.Entry<String, Integer> entry : o1.getValue().entrySet()) {
                            avg1 += entry.getValue();
                        }
                        double avg2 = 0.0;
                        for (Map.Entry<String, Integer> entry : o2.getValue().entrySet()) {
                            avg2 += entry.getValue();
                        }
                        int avgCompare = Double.compare(avg2, avg1);
                        if (avgCompare != 0) {
                            return Double.compare(avg2, avg1);
                        }
                        return o1.getKey().compareTo(o2.getKey());
                    }
                })
                .forEach(p -> {
                    int skills = 0;
                    for (Map.Entry<String, Integer> entry : p.getValue().entrySet()) {
                        skills += entry.getValue();
                    }
            System.out.printf("%s: %d skill%n", p.getKey(), skills);
            p.getValue().entrySet().stream()
                    .sorted(new Comparator<Map.Entry<String, Integer>>() {
                        @Override
                        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                            int value = Integer.compare(o2.getValue(), o1.getValue());
                            if (value != 0) {
                                return value;
                            }
                            return o1.getKey().compareTo(o2.getKey());
                        }
                    })
                    .forEach(o -> System.out.printf("- %s <::> %d%n",o.getKey(),o.getValue()));
        });
    }
}
