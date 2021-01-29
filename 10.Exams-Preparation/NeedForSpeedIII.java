package ExamPrep;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NeedForSpeedIII {
    static class Car {
        String name;
        int mileage;
        int fuel;

        public Car(String name, int mileage, int fuel) {
            this.name = name;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int carCount = Integer.parseInt(scan.nextLine());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            String[] input = scan.nextLine().split("\\|");
            Car newCar = new Car(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            carList.add(newCar);
        }
        String input = scan.nextLine();
        while (!input.equals("Stop")) {
            String[] cmd = input.split(" : ");
            switch (cmd[0]) {
                case "Drive":
                    driveCar(carList, cmd[1], Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]));
                    break;
                case "Refuel":
                    refuelCar(carList, cmd[1], Integer.parseInt(cmd[2]));
                    break;
                case "Revert":
                    revertCar(carList, cmd[1], Integer.parseInt(cmd[2]));
                    break;
            }
            input = scan.nextLine();
        }
        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                int mileage = o2.getMileage() - o1.getMileage();
                if (mileage != 0) {
                    return mileage;
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (int i = 0; i < carList.size(); i++) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", carList.get(i).getName(),
                    carList.get(i).getMileage(), carList.get(i).getFuel());

        }
    }

    private static void revertCar(List<Car> carList, String car, int mileage) {
        int carIdx = -1;
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getName().equals(car)) {
                carIdx = i;
                break;
            }
        }
        if (carIdx != -1) {
            int carMileage = carList.get(carIdx).getMileage();
            if (carMileage - mileage < 10000) {
                carList.get(carIdx).setMileage(10000);
            }
            else {
                carList.get(carIdx).setMileage(carMileage - mileage);
                System.out.printf("%s mileage decreased by %d kilometers%n", car, mileage);

            }
        }
    }

    private static void refuelCar(List<Car> carList, String car, int fuel) {
        int carIdx = -1;
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getName().equals(car)) {
                carIdx = i;
                break;
            }
        }
        if (carIdx != -1) {
            int carFuel = carList.get(carIdx).getFuel();
            if (carFuel + fuel > 75) {
                carList.get(carIdx).setFuel(75);
                System.out.printf("%s refueled with %d liters%n", car, 75 - carFuel);
            }
            else {
                carList.get(carIdx).setFuel(carFuel+fuel);
                System.out.printf("%s refueled with %d liters%n", car, fuel);

            }
        }
    }

    private static void driveCar(List<Car> carList, String car, int distance, int fuel) {
        int carIdx = -1;
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getName().equals(car)) {
                carIdx = i;
                break;
            }
        }
        if (carIdx != -1) {
            if (carList.get(carIdx).getFuel() >= fuel) {
                carList.get(carIdx).setMileage(carList.get(carIdx).getMileage() + distance);
                carList.get(carIdx).setFuel(carList.get(carIdx).getFuel() - fuel);
                System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                if (carList.get(carIdx).getMileage() >= 100000) {
                    carList.remove(carIdx);
                    System.out.printf("Time to sell the %s!%n", car);
                }

            } else System.out.println("Not enough fuel to make that ride");
        }
    }
}

