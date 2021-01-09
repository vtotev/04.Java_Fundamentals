package ObjectsAndClasses;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsLab {

    static class student {
        String firstName;
        String lastName;
        int age;
        String homeTown;

        public student(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getHomeTown() {
            return homeTown;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<student> studentsList = new ArrayList<>();
        while (!input.equals("end")) {
            String[] studInfo = input.split(" ");

            student foundStudend = studentsList.stream().filter(s -> s.getFirstName().equals(studInfo[0]) && s.getLastName().equals(studInfo[1])).findFirst().orElse(null);
            if (foundStudend == null) {
                student newStudent = new student(studInfo[0], studInfo[1], Integer.parseInt(studInfo[2]), studInfo[3]);
                studentsList.add(newStudent);
            } else {
                foundStudend.setAge(Integer.parseInt(studInfo[2]));
                foundStudend.setHomeTown(studInfo[3]);
            }

            input = scan.nextLine();
        }
        input = scan.nextLine();
        for (int i = 0; i < studentsList.size(); i++) {
            if (input.equals(studentsList.get(i).homeTown)) {
                System.out.printf("%s %s is %d years old%n", studentsList.get(i).firstName, studentsList.get(i).lastName, studentsList.get(i).age);
            }
        }
    }

}
