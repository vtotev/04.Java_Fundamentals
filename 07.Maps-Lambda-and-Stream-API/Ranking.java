package MapsLambdaStreamAPI;

import java.util.*;

public class Ranking {
    static class Student {
        String submission;
        int points;

        public Student(String submission, int points) {
            this.submission = submission;
            this.points = points;
        }

        public int getPoints() {
            return this.points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public String getSubmission() {
            return submission;
        }

        public void setSubmission(String submission) {
            this.submission = submission;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> contests = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("end of contests")) {
            String[] params = input.split(":");
            String name = params[0];
            String pass = params[1];
            contests.put(name, pass);
            input = scan.nextLine();
        }
        input = scan.nextLine();
        Map<String, List<Student>> studentList = new TreeMap<>();
        while (!input.equals("end of submissions")) {
            String[] params = input.split("=>");
            String submission = params[0];
            String submissionPass = params[1];
            String name = params[2];
            int points = Integer.parseInt(params[3]);
            if (contests.containsKey(submission) && (contests.get(submission).equals(submissionPass))) {
                if (studentList.containsKey(name)) {
                    int idx = getSubmissionIndex(studentList.get(name), submission);
                    if (idx != -1) {
                        if (studentList.get(name).get(idx).getPoints() < points) {
                            studentList.get(name).get(idx).setPoints(points);
                        }
                    } else {
                        studentList.get(name).add(new Student(submission, points));
                    }
                } else {
                    Student newStudent = new Student(submission, points);
                    List<Student> listStudents = new ArrayList<>();
                    listStudents.add(newStudent);
                    studentList.putIfAbsent(name, listStudents);
                }
            }
            input = scan.nextLine();
        }
        int maxPoints = 0;
        String maxPointsName="";
        for (Map.Entry<String, List<Student>> entry : studentList.entrySet()) {
            int sum = 0;
            Collections.sort(entry.getValue(), (o1, o2) -> Integer.compare(o2.getPoints(), o1.getPoints()));
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i).getPoints();
            }
            if (sum > maxPoints) {
                maxPoints = sum;
                maxPointsName = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", maxPointsName, maxPoints);
        System.out.println("Ranking: ");
        for (Map.Entry<String, List<Student>> entry : studentList.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("#  %s -> %s%n", entry.getValue().get(i).getSubmission(), entry.getValue().get(i).getPoints());
            }
        }
    }

    public static int getSubmissionIndex(List<Student> students, String submission) {
        int idx = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSubmission().equals(submission)) {
                return i;
            }
        }
        return idx;
    }
}
