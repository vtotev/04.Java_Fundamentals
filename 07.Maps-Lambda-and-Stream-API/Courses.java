package MapsLambdaStreamAPI;

import java.util.*;

public class Courses {
    static class Course {
        String courseName;
        List<String> students;

        public Course(String courseName, List<String> students) {
            this.courseName = courseName;
            this.students = students;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public List<String> getStudents() {
            return students;
        }

        public void setStudents(List<String> students) {
            this.students = students;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Course> courses = new ArrayList<>();
        while (!input.equals("end")) {
            String[] cmd = input.split(" : ");
            int idx = checkIfExists(courses, cmd[0]);
            if (idx != -1) {
                courses.get(idx).getStudents().add(cmd[1]);
            } else {
                Course newCourse = new Course(cmd[0], new ArrayList<>());
                newCourse.getStudents().add(cmd[1]);
                courses.add(newCourse);
            }
            input = scan.nextLine();
        }
        Collections.sort(courses, new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return Integer.compare(o2.getStudents().size(), o1.getStudents().size());
            }
        });
        for (int i = 0; i < courses.size(); i++) {
            System.out.printf("%s: %d%n", courses.get(i).getCourseName(), courses.get(i).getStudents().size());
            courses.get(i).getStudents().sort((o1, o2) -> o1.compareTo(o2));;
            for (int j = 0; j < courses.get(i).getStudents().size(); j++) {
                System.out.printf("-- %s%n", courses.get(i).getStudents().get(j));
            }
        }
    }

    public static int checkIfExists(List<Course> courseList, String courseName) {
        int idx = -1;
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseName().equals(courseName)) {
                return i;
            }
        }
        return idx;
    }
}
