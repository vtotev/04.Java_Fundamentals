package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RawData {

    static class Car {
        String model;
        int engineSpeed;
        int enginePower;
        int cargoWeight;
        String cargoType;
        List<Tyre> tyres = new ArrayList<>();

        public String getModel() {
            return model;
        }

        public int getEngineSpeed() {
            return engineSpeed;
        }

        public int getEnginePower() {
            return enginePower;
        }

        public int getCargoWeight() {
            return cargoWeight;
        }

        public String getCargoType() {
            return cargoType;
        }

        public List<Tyre> getTyres() {
            return tyres;
        }

        public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, List<Tyre> tyres) {
            this.model = model;
            this.engineSpeed = engineSpeed;
            this.enginePower = enginePower;
            this.cargoWeight = cargoWeight;
            this.cargoType = cargoType;
            this.tyres = tyres;
        }
    }

    static class Tyre {
        int tyreAge;
        double tyrePressure;

        public int getTyreAge() {
            return tyreAge;
        }

        public double getTyrePressure() {
            return tyrePressure;
        }

        public Tyre(int tyreAge, double tyrePressure) {
            this.tyreAge = tyreAge;
            this.tyrePressure = tyrePressure;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split("\\s+");
            List<Tyre> carTyres = new ArrayList<>();
            for (int j = 5; j < input.length; j += 2) {
                Tyre carSingleTyre = new Tyre(Integer.parseInt(input[j + 1]), Double.parseDouble(input[j]));
                carTyres.add(carSingleTyre);
            }
            Car newCar = new Car(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]),
                    Integer.parseInt(input[3]), input[4], carTyres);
            carList.add(newCar);
        }
        String input = scan.nextLine();
        if (input.toLowerCase().equals("fragile")) {
            for (int i = 0; i < carList.size(); i++) {
                for (int z = 0; z < carList.get(i).tyres.size(); z++) {
                    if (carList.get(i).tyres.get(z).tyrePressure < 1) {
                        System.out.println(carList.get(i).getModel());
                        break;
                    }
                }
            }
        }
        if (input.toLowerCase().equals("flamable")) {
            for (int i = 0; i < carList.size(); i++) {
                if (carList.get(i).getEnginePower() > 250)
                    System.out.println(carList.get(i).getModel());
            }
        }
    }
}
