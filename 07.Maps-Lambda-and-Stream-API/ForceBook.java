package MapsLambdaStreamAPI;

import java.util.*;

public class ForceBook {
    static class Side {
        String sideName;
        List<String> forceUsers = new ArrayList<>();

        public Side(String sideName) {
            this.sideName = sideName;
        }

        public String getSideName() {
            return sideName;
        }

        public void setSideName(String sideName) {
            this.sideName = sideName;
        }

        public List<String> getForceUsers() {
            return forceUsers;
        }

        public void setForceUsers(List<String> forceUsers) {
            this.forceUsers = forceUsers;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, List<String>> forceUsers = new TreeMap<>();
        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                String[] cmd = input.split("\\s+\\|\\s+");
                List<String> users = new ArrayList<>();
                if (!forceUsers.containsKey(cmd[0])) {
                    forceUsers.put(cmd[0], new ArrayList<>());
                }
                users = forceUsers.get(cmd[0]);
                boolean isExisting = false;
                for (Map.Entry<String, List<String>> entry : forceUsers.entrySet()) {
                    if (entry.getValue().contains(cmd[1])) {
                        isExisting = true;
                        break;
                    }
                }
                if (!isExisting) {
                    users.add(cmd[1]);
                }
                forceUsers.put(cmd[0], users);
            } else if (input.contains("->")) {
                String[] cmd = input.split("\\s+->\\s+");
                for (Map.Entry<String, List<String>> entry : forceUsers.entrySet()) {
                    if (entry.getValue().contains(cmd[0])) {
                        entry.getValue().remove(cmd[0]);
                        break;
                    }
                }
                if (!forceUsers.containsKey(cmd[1])) {
                    forceUsers.put(cmd[1], new ArrayList<>());
                }
                forceUsers.get(cmd[1]).add(cmd[0]);
                System.out.printf("%s joins the %s side!%n", cmd[0], cmd[1]);
            }
            input = scan.nextLine();
        }
        List<Side> fb = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : forceUsers.entrySet()) {
            Side newFB = new Side(entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                newFB.getForceUsers().add(entry.getValue().get(i));
            }
            fb.add(newFB);
        }
        Collections.sort(fb, new Comparator<Side>() {
            @Override
            public int compare(Side o1, Side o2) {
                int idx = o2.getForceUsers().size() - o1.getForceUsers().size();
                if (idx != 0) {
                    return idx;
                }
                return o1.getSideName().compareTo(o2.getSideName());
            }
        });
        for (int i = 0; i < fb.size(); i++) {
            if (!fb.get(i).getForceUsers().isEmpty()) {
                System.out.printf("Side: %s, Members: %d%n", fb.get(i).getSideName(), fb.get(i).getForceUsers().size());
                Collections.sort(fb.get(i).getForceUsers());
                for (int j = 0; j < fb.get(i).getForceUsers().size(); j++) {
                    System.out.printf("! %s%n", fb.get(i).getForceUsers().get(j));
                }
            }
        }
    }
}