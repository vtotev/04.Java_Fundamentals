package ExamPrep;

import java.util.Scanner;

public class WarriorsQuest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String skillName = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("For Azeroth")) {
            String[] cmd = input.split("\\s+");
            switch (cmd[0]) {
                case "GladiatorStance":
                    skillName = skillName.toUpperCase();
                    System.out.println(skillName);
                    break;

                case "DefensiveStance":
                    skillName = skillName.toLowerCase();
                    System.out.println(skillName);
                    break;

                case "Dispel":
                    int dispellIndex = Integer.parseInt(cmd[1]);
                    if (dispellIndex >= 0 && dispellIndex < skillName.length()) {
                        skillName = skillName.substring(0, dispellIndex) + cmd[2] + skillName.substring(dispellIndex + 1, skillName.length());
                        System.out.println("Success!");
                    } else {
                        System.out.println("Dispel too weak.");
                    }
                    break;

                case "Target":
                    switch (cmd[1]) {
                        case "Change":
                            while (skillName.contains(cmd[2])) {
                                skillName = skillName.replace(cmd[2], cmd[3]);
                            }
//                            skillName = skillName.replaceAll(cmd[2], cmd[3]);
                            System.out.println(skillName);
                            break;
                        case "Remove":
                            while (skillName.contains(cmd[2])) {
                                skillName = skillName.replace(cmd[2], "");
                            }
//                                skillName = skillName.replaceAll(cmd[2], "");
                            System.out.println(skillName);
                            break;
                        default:
                            System.out.println("Command doesn't exist!");
                            break;
                    }
                    break;
                default:
                    System.out.println("Command doesn't exist!");
                    break;

            }
            input = scan.nextLine();
        }
    }
}
