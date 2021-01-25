package ExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String travel = scan.nextLine();
        String regex = "(=|\\/)([A-Z][A-Za-z]{2,})\\1";
        List<String> travelLocations = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matches = pattern.matcher(travel);
        while (matches.find()) {
            travelLocations.add(matches.group(2));
        }
        int travelPoints = 0;
        String output = "";
        for (int i = 0; i < travelLocations.size(); i++) {
            travelPoints += travelLocations.get(i).length();
            output += travelLocations.get(i);
            if (i < travelLocations.size()-1) {
                output += ", ";
            }
        }
        System.out.printf("Destinations: %s%nTravel Points: %d%n", output, travelPoints);
    }
}
