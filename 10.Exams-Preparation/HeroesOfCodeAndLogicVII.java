package ExamPrep;

import java.util.*;

public class HeroesOfCodeAndLogicVII {

    static class Heroe {
        String heroName;
        int hitPoints;
        int manaPoints;

        public String getHeroName() {
            return heroName;
        }

        public void setHeroName(String heroName) {
            this.heroName = heroName;
        }

        public int getHitPoints() {
            return hitPoints;
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }

        public int getManaPoints() {
            return manaPoints;
        }

        public void setManaPoints(int manaPoints) {
            this.manaPoints = manaPoints;
        }

        public Heroe(String heroName, int hitPoints, int manaPoints) {
            this.heroName = heroName;
            this.hitPoints = hitPoints;
            this.manaPoints = manaPoints;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countHeroes = Integer.parseInt(scan.nextLine());
        List<Heroe> heroes = new ArrayList<>();
        for (int i = 0; i < countHeroes; i++) {
            String[] input = scan.nextLine().split(" ");
            Heroe newHeroe = new Heroe(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            heroes.add(newHeroe);
        }
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] cmd = input.split(" - ");
            switch (cmd[0]) {
                case "CastSpell":
                    System.out.println(castSpell(heroes, cmd[1], Integer.parseInt(cmd[2]), cmd[3]));
                    break;
                case "TakeDamage":
                    System.out.println(takeDamage(heroes, cmd[1], Integer.parseInt(cmd[2]), cmd[3]));
                    break;
                case "Recharge":
                    System.out.println(recharge(heroes, cmd[1], Integer.parseInt(cmd[2])));
                    break;
                case "Heal":
                    System.out.println(healHero(heroes, cmd[1], Integer.parseInt(cmd[2])));
                    break;
            }
            input = scan.nextLine();
        }

        Collections.sort(heroes, new Comparator<Heroe>() {
            @Override
            public int compare(Heroe o1, Heroe o2) {
                int health = o2.getHitPoints() - o1.getHitPoints();
                if (health != 0)
                    return health;
                String name1 = o1.getHeroName();
                String name2 = o2.getHeroName();
                int nameComp = name1.compareTo(name2);
                return nameComp;
            }
        });

        for (int i = 0; i < heroes.size(); i++) {
            System.out.printf("%s%n  HP: %d%n  MP: %d%n",
                    heroes.get(i).getHeroName(),
                    heroes.get(i).getHitPoints(),
                    heroes.get(i).getManaPoints());
        }
    }

    private static String healHero(List<Heroe> heroes, String heroName, int amount) {
        String result = "";
        for (int i = 0; i < heroes.size(); i++) {
            String currHero = heroes.get(i).getHeroName();
            if (currHero.equals(heroName)) {
                int heroHP = heroes.get(i).getHitPoints();
                if (heroHP + amount > 100) {
                    heroes.get(i).setHitPoints(100);
                    result = String.format("%s healed for %d HP!",
                            heroName, (100 - heroHP));
                } else {
                    heroes.get(i).setHitPoints(heroHP + amount);
                    result = String.format("%s healed for %d HP!",
                            heroName, amount);
                }
            }
        }
        return result;
    }

    private static String recharge(List<Heroe> heroes, String heroName, int amount) {
        String result = "";
        for (int i = 0; i < heroes.size(); i++) {
            String currHero = heroes.get(i).getHeroName();
            if (currHero.equals(heroName)) {
                int heroMP = heroes.get(i).getManaPoints();
                if (heroMP + amount > 200) {
                    heroes.get(i).setManaPoints(200);
                    result = String.format("%s recharged for %d MP!",
                            heroName, (200 - heroMP));
                } else {
                    heroes.get(i).setManaPoints(heroMP + amount);
                    result = String.format("%s recharged for %d MP!",
                            heroName, amount);
                }
            }
        }
        return result;
    }

    private static String takeDamage(List<Heroe> heroes, String heroName, int damage, String attacker) {
        String result = "";
        for (int i = 0; i < heroes.size(); i++) {
            String currHero = heroes.get(i).getHeroName();
            if (currHero.equals(heroName)) {
                int heroehitPoints = heroes.get(i).getHitPoints();
                if (heroehitPoints > damage) {
                    heroes.get(i).setHitPoints(heroehitPoints - damage);
                    result = String.format("%s was hit for %d HP by %s and now has %d HP left!",
                            heroName, damage, attacker, heroes.get(i).getHitPoints());
                } else {
                    result = String.format("%s has been killed by %s!", heroName, attacker);
                    heroes.remove(i);
                }
            }
        }
        return result;
    }

    private static String castSpell(List<Heroe> heroes, String heroName, int mpNeeded, String spellName) {
        String result = "";
        for (int i = 0; i < heroes.size(); i++) {
            String currHero = heroes.get(i).getHeroName();
            if (currHero.equals(heroName)) {
                int heroeManaPoints = heroes.get(i).getManaPoints();
                if (heroeManaPoints >= mpNeeded) {
                    heroes.get(i).setManaPoints(heroeManaPoints - mpNeeded);
                    result = String.format("%s has successfully cast %s and now has %d MP!",
                            heroName, spellName, heroes.get(i).getManaPoints());
                } else {
                    result = String.format("%s does not have enough MP to cast %s!", heroName, spellName);
                }
            }
        }
        return result;
    }
}
