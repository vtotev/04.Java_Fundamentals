package MapsLambdaStreamAPI;

import java.util.*;

public class DragonArmy {
    static class Dragon {
        String name;
        int health;
        int damage;
        int armor;

        public Dragon(String name, int health, int damage, int armor) {
            this.name = name;
            this.health = health;
            this.damage = damage;
            this.armor = armor;
        }

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

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Dragon>> dragonsList = new LinkedHashMap<>();
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            int health = 250;
            int armor = 10;
            int damage = 45;
            if (!input[2].equals("null")) {
                damage = Integer.parseInt(input[2]);
            }
            if (!input[3].equals("null")) {
                health = Integer.parseInt(input[3]);
            }
            if (!input[4].equals("null")) {
                armor = Integer.parseInt(input[4]);
            }
            if (!dragonsList.containsKey(type)) {
                dragonsList.put(type, new ArrayList<>());
            }
            List<Dragon> currDragons = dragonsList.get(type);
            int dragonIndex = checkDragonExists(dragonsList, type, name);
            if (dragonIndex != -1) {
                dragonsList.get(type).get(dragonIndex).setArmor(armor);
                dragonsList.get(type).get(dragonIndex).setDamage(damage);
                dragonsList.get(type).get(dragonIndex).setHealth(health);
            } else {
                Dragon newDragon = new Dragon(name, health, damage, armor);
                currDragons.add(newDragon);
            }
            dragonsList.put(type, currDragons);
        }
        dragonsList.entrySet().stream().forEach(o -> {
            double avgDamage = 0.0;
            double avgHealth = 0.0;
            double avgArmor = 0.0;
            for (int i = 0; i < o.getValue().size(); i++) {
                avgDamage += o.getValue().get(i).getDamage();
                avgHealth += o.getValue().get(i).getHealth();
                avgArmor += o.getValue().get(i).getArmor();
            }
            avgDamage /= o.getValue().size();
            avgHealth /= o.getValue().size();
            avgArmor /= o.getValue().size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", o.getKey(), avgDamage, avgHealth, avgArmor);
            o.getValue().stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).forEach(dr -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                    dr.getName(), dr.getDamage(), dr.getHealth(), dr.getArmor()));
        });
    }

    private static int checkDragonExists(Map<String, List<Dragon>> dragonsList, String type, String name) {
        int idx = -1;
        for (int i = 0; i < dragonsList.get(type).size(); i++) {
            if (dragonsList.get(type).get(i).getName().equals(name)) {
                return i;
            }
        }
        return idx;
    }
}
