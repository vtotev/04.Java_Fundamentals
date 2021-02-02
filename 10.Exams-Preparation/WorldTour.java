package ExamPrep;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String travel = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Travel")) {
            String[] cmd = input.split(":");
            switch (cmd[0]){
                case "Add Stop":
                    int addIdx = Integer.parseInt(cmd[1]);
                    if (addIdx >= 0 && addIdx <= travel.length()) {
                        travel = travel.substring(0, addIdx) + cmd[2] + travel.substring(addIdx, travel.length());
                    }
                    System.out.println(travel);
                    break;
                case "Remove Stop":
                    int startIdx = Integer.parseInt(cmd[1]);
                    int endIdx = Integer.parseInt(cmd[2])+1;
                    if (startIdx >= 0 && endIdx <= travel.length()) {
                        travel = travel.substring(0, startIdx) + travel.substring(endIdx, travel.length());
                    }
                    System.out.println(travel);
                    break;
                case "Switch":
                    travel = travel.replaceAll(cmd[1], cmd[2]);
                    System.out.println(travel);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + travel);
    }
}
