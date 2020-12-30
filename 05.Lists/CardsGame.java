package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstPlayerCards = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerCards = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        while (true) {
            int firstPlayer = firstPlayerCards.get(0);
            int secondPlayer = secondPlayerCards.get(0);
            if (firstPlayer > secondPlayer) {
                firstPlayerCards.add(firstPlayer);
                firstPlayerCards.add(secondPlayer);
            } else if (firstPlayer < secondPlayer) {
                secondPlayerCards.add(secondPlayer);
                secondPlayerCards.add(firstPlayer);
            }
            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);

            if (firstPlayerCards.isEmpty()) {
                int sum = 0;
                for (int i = 0; i < secondPlayerCards.size(); i++) {
                    sum += secondPlayerCards.get(i);
                }
                System.out.println("Second player wins! Sum: " + sum);
                break;
            }
            else if (secondPlayerCards.isEmpty()) {
                int sum = 0;
                for (int i = 0; i < firstPlayerCards.size(); i++) {
                    sum += firstPlayerCards.get(i);
                }
                System.out.println("First player wins! Sum: " + sum);
                break;
            }
        }
    }
}
