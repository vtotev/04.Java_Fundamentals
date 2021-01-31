package ExamPrep;

import java.util.*;

public class Pirates {
    static class City {
        String name;
        int population;
        int gold;

        public City(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<String> cities = new ArrayList<>();
        List<Integer> population = new ArrayList<>();
        List<Integer> gold = new ArrayList<>();
        while (!input.equals("Sail")) {
            String[] commands = input.split("\\|\\|");
            int indx = cities.indexOf(commands[0]);
            if (indx != -1) {
                int newPopulaton = population.get(indx) + Integer.parseInt(commands[1]);
                population.set(indx, newPopulaton);
                int newGold = gold.get(indx) + Integer.parseInt(commands[2]);
                gold.set(indx, newGold);
            } else {
                cities.add(commands[0]);
                population.add(Integer.parseInt(commands[1]));
                gold.add(Integer.parseInt(commands[2]));
            }
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split("\\=\\>");
            String town = commands[1];
            int townIndx = cities.indexOf(town);
            switch (commands[0]) {
                case "Plunder":
                    if (townIndx != -1) {
                        int newPopulation = population.get(townIndx) - Integer.parseInt(commands[2]);
                        population.set(townIndx, newPopulation);
                        int newGold = gold.get(townIndx) - Integer.parseInt(commands[3]);
                        gold.set(townIndx, newGold);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", commands[1],
                                Integer.parseInt(commands[3]), Integer.parseInt(commands[2]));
                        if ((population.get(townIndx) <= 0) || (gold.get(townIndx) <= 0)) {
                            cities.remove(townIndx);
                            population.remove(townIndx);
                            gold.remove(townIndx);
                            System.out.printf("%s has been wiped off the map!%n", commands[1]);
                        }
                    }
                    break;
                case "Prosper":
                    if (Integer.parseInt(commands[2]) < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    }
                    if (townIndx != -1) {
                        int newGold = gold.get(townIndx) + Integer.parseInt(commands[2]);
                        gold.set(townIndx, newGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                Integer.parseInt(commands[2]), commands[1], newGold);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        List<City> cityList = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++) {
            City newCity = new City(cities.get(i), population.get(i), gold.get(i));
            cityList.add(newCity);
        }
        if (cityList.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
            return;
        }
        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cityList.size());

        cityList.stream().sorted(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                int gold = o2.gold - o1.gold;
                if (gold != 0)
                    return gold;
                String name1 = o1.name;
                String name2 = o2.name;
                int nameComp = name1.compareTo(name2);
                return nameComp;
            }
        }).forEach(o -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                o.name, o.population, o.gold));
/*        Collections.sort(cityList, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                int gold = o2.gold - o1.gold;
                if (gold != 0)
                    return gold;
                String name1 = o1.name;
                String name2 = o2.name;
                int nameComp = name1.compareTo(name2);
                return nameComp;
            }
        });
        for (int i = 0; i < cityList.size(); i++) {
            System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                    cityList.get(i).name, cityList.get(i).population, cityList.get(i).gold);
        }*/
    }
}
