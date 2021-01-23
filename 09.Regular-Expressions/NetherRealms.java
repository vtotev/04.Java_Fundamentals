package RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    static class Demon {
        String name;
        int health;
        double damage;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public double getDamage() {
            return damage;
        }

        public void setDamage(double damage) {
            this.damage = damage;
        }

        public Demon(String name, int health, double damage) {
            this.name = name;
            this.health = health;
            this.damage = damage;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regexHealth = "[^0-9+\\-*/.]+";
        //String regexDamage = "(?<dmg>[0-9.\\-]*)";
        String regexDamage = "[-|+]?[0-9]+([.][0-9]+)*";

        Pattern pattHP = Pattern.compile(regexHealth);
        Pattern pattDmg = Pattern.compile(regexDamage);
        List<Demon> demonList = new ArrayList<>();
        String[] input = scan.nextLine().split(",\\s*");
        for (String item : input) {
            item = item.replaceAll(" ", "");
            int countMultiply = 0;
            int countDivide = 0;
            Matcher matcherHP = pattHP.matcher(item);
            String HPSymbols = "";
            while (matcherHP.find()) {
                HPSymbols += matcherHP.group(0);
            }
            int outputHP = 0;
            for (int i = 0; i < HPSymbols.length(); i++) {
                outputHP += HPSymbols.charAt(i);
            }
            double outputDamage = 0.0;
            Matcher matcherDmg = pattDmg.matcher(item);
            while (matcherDmg.find()) {
                if (!matcherDmg.group(0).equals(""))
                    outputDamage += Double.parseDouble(matcherDmg.group(0));
            }
            for (int i = 0; i < item.length(); i++) {
                if (item.charAt(i) == '*') {
                    countMultiply++;
                } else if (item.charAt(i) == '/') {
                    countDivide++;
                }
            }
            for (int i = 0; i < countMultiply; i++) {
                outputDamage *= 2;
            }
            for (int i = 0; i < countDivide; i++) {
                outputDamage /= 2;
            }
            Demon newDemon = new Demon(item, outputHP, outputDamage);
            demonList.add(new Demon(item, outputHP, outputDamage));
        }

        demonList.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).forEach(o -> System.out.printf("%s - %d health, %.2f damage%n", o.getName(), o.getHealth(), o.getDamage()));
    }
}
