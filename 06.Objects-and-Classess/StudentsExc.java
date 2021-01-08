package ObjectsAndClasses;

import java.util.*;

public class StudentsExc {

    static class Student {
        String firstName;
        String lastName;
        double grade;

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

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f", firstName, lastName, grade);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split(" ");
            Student newStudent = new Student(input[0], input[1], Double.parseDouble(input[2]));
            studentList.add(newStudent);
        }
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.grade, o2.grade);
            }
        });
        Collections.reverse(studentList);
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).toString());
        }
    }
}
