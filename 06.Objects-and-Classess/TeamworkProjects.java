package ObjectsAndClasses;

import java.util.*;

public class TeamworkProjects {

    static class Team {
        String teamName;
        String creator;

        public Team(String teamName, String creator) {
            this.teamName = teamName;
            this.creator = creator;
        }

        List<String> members = new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countTeams = Integer.parseInt(scan.nextLine());
        List<Team> teamList = new ArrayList<>();
        for (int i = 0; i < countTeams; i++) {
            String[] newTeam = scan.nextLine().split("-");
            if (teamList.stream().noneMatch(s -> s.teamName.equals(newTeam[1]))) {
                if (teamList.stream().noneMatch(s -> s.creator.equals(newTeam[0]))) {
                    Team team = new Team(newTeam[1], newTeam[0]);
                    teamList.add(team);
                    System.out.printf("Team %s has been created by %s!%n", newTeam[1], newTeam[0]);
                } else {
                    System.out.printf("%s cannot create another team!%n", newTeam[0]);
                }
            } else {
                System.out.printf("Team %s was already created!%n", newTeam[1]);
            }
        }
        String input = scan.nextLine();
        while (!input.equals("end of assignment")) {
            String[] inpArr = input.split("->");
            String membertoJoin = inpArr[0];
            String teamToJoin = inpArr[1];

            if (!teamList.stream().noneMatch(s -> s.teamName.equals(teamToJoin))) {
                int teamIndex = -1;
                int inLists = -1;
                for (int i = 0; i < teamList.size(); i++) {
                    if (teamList.get(i).teamName.equals(teamToJoin)) {
                        teamIndex = i;
                    }
                    if (teamList.get(i).members.indexOf(membertoJoin) != -1)
                        inLists++;
                }
                if (teamIndex != -1) {
                    if (inLists == -1 && !membertoJoin.equals(teamList.get(teamIndex).creator)) {
                        teamList.get(teamIndex).members.add(membertoJoin);
                    } else {
                        System.out.printf("Member %s cannot join team %s!%n", membertoJoin, teamToJoin);
                    }
                }
            } else {
                System.out.printf("Team %s does not exist!%n", teamToJoin);
            }

            input = scan.nextLine();
        }
        Collections.sort(teamList, new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                int sizeCmp = o2.members.size() - o1.members.size();
                if (sizeCmp != 0)
                    return sizeCmp;
                String name1 = o1.teamName;
                String name2 = o2.teamName;
                int nameComp = o1.teamName.compareTo(o2.teamName);
                return nameComp;
            }
        });
        List<String> teamsToDisband = new ArrayList<>();
        for (int i = 0; i < teamList.size(); i++) {
            if (!teamList.get(i).members.isEmpty()) {
                System.out.printf("%s%n", teamList.get(i).teamName);
                System.out.printf("- %s%n", teamList.get(i).creator);
                Collections.sort(teamList.get(i).members);
                for (int j = 0; j < teamList.get(i).members.size(); j++) {
                    System.out.printf("-- %s%n", teamList.get(i).members.get(j));
                }
            } else {
                teamsToDisband.add(teamList.get(i).teamName);
            }
        }
        System.out.println("Teams to disband:");
        for (int i = 0; i < teamsToDisband.size(); i++) {
            System.out.printf("%s%n", teamsToDisband.get(i));
        }
    }
}
