package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> bothRacersArray = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> firstRacer = new ArrayList<>();
        List<Integer> secondRacer = new ArrayList<>();
        for (int i = 0, j = bothRacersArray.size()-1; i < (bothRacersArray.size()/2) && j > (bothRacersArray.size()/2); i++, j--) {
            firstRacer.add(bothRacersArray.get(i));
            secondRacer.add(bothRacersArray.get(j));
        }
        double firstRacerTime = 0;
        for (int i = 0; i < firstRacer.size(); i++) {
            int currNum = firstRacer.get(i);
            if (currNum == 0) {
                firstRacerTime *= 0.8;
            } else firstRacerTime += currNum;
        }
        double secondRacerTime = 0;
        for (int i = 0; i < secondRacer.size(); i++) {
            int currNum = secondRacer.get(i);
            if (currNum == 0) {
                secondRacerTime *= 0.8;
            } else secondRacerTime += currNum;
        }

        if (firstRacerTime < secondRacerTime) {
            System.out.printf("The winner is left with total time: %.1f", firstRacerTime);
        } else System.out.printf("The winner is right with total time: %.1f", secondRacerTime);
    }
}
