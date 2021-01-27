package ExamPrep;

import java.util.*;

public class HeroRecruitment {
    static class Heroe {
        String name;
        List<String> spellBook = new ArrayList<>();
        public Heroe (String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getSpellBook() {
            return spellBook;
        }

        public void setSpellBook(List<String> spellBook) {
            this.spellBook = spellBook;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Heroe> heroeList = new ArrayList<>();
        while (!input.equals("End")) {
            String[] cmd = input.split("\\s+");
            int heroIndex = heroeExists(heroeList, cmd[1]);
            switch (cmd[0]) {
                case "Enroll":
                    if (heroIndex == -1) {
                        Heroe newHero = new Heroe(cmd[1]);
                        heroeList.add(newHero);
                    }
                    else {
                        System.out.printf("%s is already enrolled.%n", cmd[1]);
                    }
                    break;

                case "Learn":
                    if (heroIndex != -1) {
                        int spellLearnIndex = spellExists(heroeList, heroIndex, cmd[2]);
                        if (spellLearnIndex == -1) {
                            heroeList.get(heroIndex).getSpellBook().add(cmd[2]);
                        } else {
                            System.out.printf("%s has already learnt %s.%n", cmd[1], cmd[2]);
                        }
                    }
                    else {
                        System.out.printf("%s doesn't exist.%n", cmd[1]);
                    }
                    break;

                case "Unlearn":
                    if (heroIndex != -1) {
                        int spellUnearnIndex = spellExists(heroeList, heroIndex, cmd[2]);
                        if (spellUnearnIndex != -1) {
                            heroeList.get(heroIndex).getSpellBook().remove(spellUnearnIndex);
                        } else {
                            System.out.printf("%s doesn't know %s.%n", cmd[1], cmd[2]);
                        }
                    }
                    else {
                        System.out.printf("%s doesn't exist.%n", cmd[1]);
                    }
                    break;

            }

            input = scan.nextLine();
        }
        Collections.sort(heroeList, new Comparator<Heroe>() {
            @Override
            public int compare(Heroe o1, Heroe o2) {
                int spells = o2.getSpellBook().size() - o1.getSpellBook().size();
                if (spells != 0) {
                    return spells;
                }

                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Heroes:");
        for (int i = 0; i < heroeList.size(); i++) {
            String spells = ": ";
            if (!heroeList.get(i).getSpellBook().isEmpty()) {
                for (int j = 0; j < heroeList.get(i).getSpellBook().size(); j++) {
                    spells += heroeList.get(i).getSpellBook().get(j);
                    if (j != heroeList.get(i).getSpellBook().size()-1) {
                        spells += ", ";
                    }
                }
            }
            System.out.printf("== %s%s%n", heroeList.get(i).getName(), spells);

        }
    }

    public static int heroeExists(List<Heroe> heroeList, String heroeName) {
        int index = -1;
        for (int i = 0; i < heroeList.size(); i++) {
            if (heroeList.get(i).getName().equals(heroeName)) {
                return i;
            }
        }
        return index;
    }

    public static int spellExists(List<Heroe> heroList, int heroIndex, String spellName) {
        int index = -1;
        for (int i = 0; i < heroList.get(heroIndex).getSpellBook().size(); i++) {
            if (heroList.get(heroIndex).getSpellBook().get(i).equals(spellName)) {
                return i;
            }
        }
        return index;
    }
}
