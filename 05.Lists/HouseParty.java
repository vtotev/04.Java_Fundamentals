package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scan.nextLine());
        List<String> guests = new ArrayList<>();
        for (int i = 0; i < peopleCount; i++) {
            String[] command = scan.nextLine().split(" ");
            String name = command[0];
            boolean isGoing = command[2].equals("going!");
            if (isGoing) {
                if (!guests.contains(name)) {
                    guests.add(name);
                } else System.out.printf("%s is already in the list!%n", name);
            }
            else {
                if (guests.contains(name)) {
                    guests.remove(name);
                } else System.out.printf("%s is not in the list!%n", name);
            }
        }
        for (int i = 0; i < guests.size(); i++) {
            System.out.println(guests.get(i));
        }
    }
}
