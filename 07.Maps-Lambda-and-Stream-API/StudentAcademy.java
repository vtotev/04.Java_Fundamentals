package MapsLambdaStreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentAcademy {
    static class Student{
        String name;
        double avgGrade = 0.0;

        public Student(String name, double avgGrade) {
            this.name = name;
            this.avgGrade = avgGrade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getAvgGrade() {
            return avgGrade;
        }

        public void setAvgGrade(double avgGrade) {
            this.avgGrade = avgGrade;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String name = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());
            int idx = checkIfExists(studentList, name);
            if (idx != -1) {
                studentList.get(idx).setAvgGrade((studentList.get(idx).getAvgGrade()+grade)/2);
            } else {
                Student newStudent = new Student(name, grade);
                studentList.add(newStudent);
            }
        }
        List<Student> sortedList = studentList.stream()
                .filter(o1 -> o1.getAvgGrade() >= 4.5)
                .sorted(((o1, o2) -> Double.compare(o2.getAvgGrade(), o1.getAvgGrade()))).collect(Collectors.toList());
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.printf("%s -> %.2f%n", sortedList.get(i).getName(), sortedList.get(i).getAvgGrade());
        }
    }

    public static int checkIfExists(List<Student> students, String studentName) {
        int idx = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(studentName)) {
                return i;
            }
        }
        return idx;
    }
}
