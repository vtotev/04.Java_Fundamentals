package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSalesman {

    static class Car {
        String model;
        Engine engine;
        int weight = -1;
        String color = "n/a";

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Engine getEngine() {
            return engine;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Car(String model, Engine engine) {
            this.model = model;
            this.engine = engine;
        }

        @Override
        public String toString() {
            String weightToStr = "";
            if (getWeight() != -1)
                weightToStr = getWeight()+"";
            else weightToStr = "n/a";
            return String.format("%s:%n%s%nWeight: %s%nColor: %s", getModel(), getEngine().toString(),
                    weightToStr, getColor());
        }
    }

    static class Engine {
        String model;
        int power;
        int displacement = -1;
        String efficiency = "n/a";

        public Engine(String model, int power) {
            this.model = model;
            this.power = power;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public int getDisplacement() {
            return displacement;
        }

        public void setDisplacement(int displacement) {
            this.displacement = displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }

        public void setEfficiency(String efficiency) {
            this.efficiency = efficiency;
        }

        @Override
        public String toString() {
            String displacementAsStr = "n/a";
            if (getDisplacement() != -1) {
                displacementAsStr = getDisplacement()+"";
            }
            return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s", getModel(), getPower(), displacementAsStr, getEfficiency());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int engCount = Integer.parseInt(scan.nextLine());
        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < engCount; i++) {
            String[] engInput = scan.nextLine().split("\\s+");
            Engine newEngine = new Engine(engInput[0], Integer.parseInt(engInput[1]));
            if (engInput.length == 3) {
                if (Character.isDigit(engInput[2].charAt(0))) {
                    newEngine.setDisplacement(Integer.parseInt(engInput[2]));
                } else {
                    newEngine.setEfficiency(engInput[2]);
                }
            }
            if (engInput.length == 4) {
                newEngine.setDisplacement(Integer.parseInt(engInput[2]));
                newEngine.setEfficiency(engInput[3]);
            }
            engineList.add(newEngine);
        }

        int carCount = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < carCount; i++) {
            String[] carInput = scan.nextLine().split("\\s+");
            int engIndex = -1;
            for (int j = 0; j < engineList.size(); j++) {
                if (engineList.get(j).getModel().equals(carInput[1])) {
                    engIndex = j;
                    break;
                }
            }

            Car newCar = new Car(carInput[0], engineList.get(engIndex));
            if (carInput.length == 3) {
                if (Character.isDigit(carInput[2].charAt(0))) {
                    newCar.setWeight(Integer.parseInt(carInput[2]));
                } else {
                    newCar.setColor(carInput[2]);
                }
            }
            if (carInput.length == 4) {
                newCar.setWeight(Integer.parseInt(carInput[2]));
                newCar.setColor(carInput[3]);
            }
            carList.add(newCar);
            System.out.println(newCar.toString());
        }
    }
}
