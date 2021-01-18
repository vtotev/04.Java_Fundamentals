package MapsLambdaStreamAPI;

import java.nio.file.LinkPermission;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        Map<String, String> parkingLot = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            String[] cmd = scan.nextLine().split(" ");
            switch (cmd[0]) {
                case "register":
                    if (parkingLot.containsKey(cmd[1])) {
                        System.out.printf("ERROR: already registered with plate number %s%n", parkingLot.get(cmd[1]));
                    } else {
                        System.out.printf("%s registered %s successfully%n", cmd[1], cmd[2]);
                        parkingLot.putIfAbsent(cmd[1], cmd[2]);
                    }
                    break;
                case "unregister":
                    if (!parkingLot.containsKey(cmd[1])) {
                        System.out.printf("ERROR: user %s not found%n", cmd[1]);
                    } else {
                        System.out.printf("%s unregistered successfully%n", cmd[1]);
                        parkingLot.remove(cmd[1]);
                    }
                    break;
            }
        }
        for (Map.Entry<String, String> entry : parkingLot.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
