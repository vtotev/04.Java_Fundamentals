package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> lessonsList = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.toLowerCase().equals("course start")) {
            String[] commands = input.split(":");
            manageCourse(lessonsList, commands);
            input = scan.nextLine();
        }
        for (int i = 0; i < lessonsList.size(); i++) {
            System.out.println(i + 1 + "." + lessonsList.get(i));
        }
    }

    private static void manageCourse(List<String> lessonsList, String[] commands) {
        switch (commands[0]) {
            case "Add":
                if (!lessonsList.contains(commands[1]))
                    lessonsList.add(commands[1]);
                break;

            case "Insert":
                if (!lessonsList.contains(commands[1]))
                    lessonsList.add(Integer.parseInt(commands[2]), commands[1]);
                break;

            case "Remove":
                if (lessonsList.contains(commands[1]))
                    lessonsList.remove((Object) commands[1]);
                break;

            case "Swap":
                String firstLesson = commands[1];
                String secondLesson = commands[2];
                if (lessonsList.contains(firstLesson) && lessonsList.contains(secondLesson)) {
                    int firstIndex = lessonsList.indexOf(firstLesson);
                    int secondIndex = lessonsList.indexOf(secondLesson);
                    lessonsList.set(firstIndex, secondLesson);
                    lessonsList.set(secondIndex, firstLesson);
                    if (lessonsList.contains(firstLesson + "-Exercise")) {
                        int excIndex = lessonsList.indexOf(firstLesson + "-Exercise");
                        lessonsList.remove(excIndex);
                        lessonsList.add(lessonsList.indexOf(firstLesson) + 1, firstLesson + "-Exercise");
                    }
                    if (lessonsList.contains(secondLesson + "-Exercise")) {
                        int excIndex = lessonsList.indexOf(secondLesson + "-Exercise");
                        lessonsList.remove(excIndex);
                        lessonsList.add(lessonsList.indexOf(secondLesson) + 1, secondLesson + "-Exercise");
                    }
                }
                break;

            case "Exercise":
                if (lessonsList.contains(commands[1]) && lessonsList.contains(commands[1]+"-Exercise"))
                    break;

                if (lessonsList.contains(commands[1])) {
                    int indx = lessonsList.indexOf(commands[1]);
                    lessonsList.add(indx + 1, commands[1] + "-Exercise");
                } else {
                    lessonsList.add(commands[1]);
                    lessonsList.add(commands[1] + "-Exercise");
                }
                break;
        }
    }
}
