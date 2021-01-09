package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogueExc {

    static class Vehicle {
        String type;
        String model;
        String color;
        int horsepower;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getModel() {
            return model;
        }

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        @Override
        public String toString() {
            String newType;
            if (type.toLowerCase().equals("car")) {
                newType = "Car";
            } else newType = "Truck";
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d%n", newType, model, color, horsepower);
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Vehicle> vehiclesList = new ArrayList<>();
        double carsHP = 0.0;
        int carsCount = 0;
        double trucksHP = 0.0;
        int trucksCount = 0;
        while (!input.toLowerCase().equals("end")) {
            String[] inputData = input.split("\\s+");
            Vehicle newVehicle = new Vehicle(inputData[0], inputData[1], inputData[2], Integer.parseInt(inputData[3]));
            if (inputData[0].toLowerCase().equals("car")) {
                carsHP += Integer.parseInt(inputData[3]);
                carsCount++;
                vehiclesList.add(newVehicle);
            }
            if (inputData[0].toLowerCase().equals("truck")) {
                trucksHP += Integer.parseInt(inputData[3]);
                trucksCount++;
                vehiclesList.add(newVehicle);
            }
            input = scan.nextLine();
        }

        input = scan.nextLine();
        while (!input.toLowerCase().equals("close the catalogue")) {
            for (int i = 0; i < vehiclesList.size(); i++) {
                if (vehiclesList.get(i).getModel().toLowerCase().equals(input.toLowerCase())) {
                    System.out.print(vehiclesList.get(i).toString());
                }
            }
            input = scan.nextLine();
        }
        double noHP = 0.00;
        if (carsCount > 0) {
            System.out.printf("Cars have average horsepower of: %.2f.%n", carsHP / carsCount);
        } else System.out.printf("Cars have average horsepower of: %.2f.%n", noHP);

        if (trucksCount > 0) {
            System.out.printf("Trucks have average horsepower of: %.2f.", trucksHP / trucksCount);
        } else  System.out.printf("Trucks have average horsepower of: %.2f.", noHP);
    }
}
