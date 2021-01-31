package ExamPrep;

import java.beans.IndexedPropertyChangeEvent;
import java.util.*;

public class PlantDiscovery {
    static class Plant {
        String plant;
        int rarity;
        List<Integer> rating = new ArrayList<>();
        double avgRating = 0.0d;

        public double getAvgRating() {
            return avgRating;
        }

        public void setAvgRating(double avgRating) {
            this.avgRating = avgRating;
        }

        public Plant(String plant, int rarity) {
            this.plant = plant;
            this.rarity = rarity;
        }

        public String getPlant() {
            return plant;
        }

        public void setPlant(String plant) {
            this.plant = plant;
        }

        public int getRarity() {
            return rarity;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public List<Integer> getRating() {
            return rating;
        }

        public void setRating(List<Integer> rating) {
            this.rating = rating;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<Plant> plantList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split("<->");
            int checkIndx = checkForPlant(plantList, input[0]);
            if (checkIndx == -1) {
                Plant newPlant = new Plant(input[0], Integer.parseInt(input[1]));
                plantList.add(newPlant);
            } else {
                plantList.get(i).setRarity(Integer.parseInt(input[1]));
            }
        }

        String input = scan.nextLine();
        while (!input.equals("Exhibition")) {
            String[] cmd = input.split(": ");
            switch (cmd[0]) {
                case "Rate":
                    String[] subCmd = cmd[1].split(" - ");
                    int rateIndx = checkForPlant(plantList, subCmd[0]);
                    if (rateIndx != -1) {
                        plantList.get(rateIndx).getRating().add(Integer.parseInt(subCmd[1]));
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    String[] updCmd = cmd[1].split(" - ");
                    int updIndx = checkForPlant(plantList, updCmd[0]);
                    if (updIndx != -1) {
                        plantList.get(updIndx).setRarity(Integer.parseInt(updCmd[1]));
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    int resetIdx = checkForPlant(plantList, cmd[1]);
                    if (resetIdx != -1) {
                        plantList.get(resetIdx).getRating().clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            input = scan.nextLine();
        }
        getAverageRatings(plantList);

        Collections.sort(plantList, new Comparator<Plant>() {
            @Override
            public int compare(Plant o1, Plant o2) {
                int rarity = o2.getRarity() - o1.getRarity();
                if (rarity != 0) {
                    return rarity;
                }
                return Double.compare(o2.getAvgRating(), o1.getAvgRating());
            }
        });
        System.out.println("Plants for the exhibition:");
        for (int i = 0; i < plantList.size(); i++) {
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plantList.get(i).getPlant(),
                    plantList.get(i).getRarity(), plantList.get(i).getAvgRating());
        }
    }

    private static void getAverageRatings(List<Plant> plantList) {
        for (int i = 0; i < plantList.size(); i++) {
            double sum = 0.0;
            if (!plantList.get(i).getRating().isEmpty()) {
                for (int j = 0; j < plantList.get(i).getRating().size(); j++) {
                    sum += plantList.get(i).getRating().get(j);
                }
                sum /= plantList.get(i).getRating().size();
                plantList.get(i).setAvgRating(sum);
            }
        }
    }

    private static int checkForPlant(List<Plant> plantList, String plantName) {
        int index = -1;
        for (int i = 0; i < plantList.size(); i++) {
            if (plantList.get(i).getPlant().equals(plantName)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
