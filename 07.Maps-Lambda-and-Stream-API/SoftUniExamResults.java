package MapsLambdaStreamAPI;

import java.util.*;

public class SoftUniExamResults {
    static class StudentData {
        String name;
        int points = 0;
        boolean banned = false;

        public boolean isBanned() {
            return banned;
        }

        public void setBanned(boolean banned) {
            this.banned = banned;
        }

        public StudentData(String name, int points) {
            this.name = name;
            this.points = points;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<StudentData>> students = new TreeMap<>();
        Map<String, Integer> submissions = new TreeMap<>();
        String input = scan.nextLine();
        while (!input.equals("exam finished")) {
            if (!input.contains("-banned")) {
                String[] cmd = input.split("-");
                String name = cmd[0];
                String submission = cmd[1];
                int points = Integer.parseInt(cmd[2]);
                students.putIfAbsent(submission, new ArrayList<>());
                submissions.putIfAbsent(submission, 0);
                List<StudentData> studentInfo = students.get(submission);
                int checkIndex = getStudentIndex(studentInfo, name);
                if (checkIndex != -1) {
                    if (studentInfo.get(checkIndex).getPoints() < points) {
                        studentInfo.get(checkIndex).setPoints(points);
                    }
                } else {
                    StudentData newStudent = new StudentData(name, points);
                    studentInfo.add(newStudent);
                }
                students.put(submission, studentInfo);
                submissions.put(submission, submissions.get(submission)+1);
            } else {
                String[] cmdBan = input.split("-");
                String name = cmdBan[0];
                for (Map.Entry<String, List<StudentData>> entry : students.entrySet()) {
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        if (entry.getValue().get(i).getName().equals(name)) {
                            entry.getValue().get(i).setBanned(true);
                        }
                    }
                }
            }
            input = scan.nextLine();
        }
        List<StudentData> forPrint = new ArrayList<>();
        for (Map.Entry<String, List<StudentData>> entry : students.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                StudentData student = new StudentData(entry.getValue().get(i).getName(),
                        entry.getValue().get(i).getPoints());
                student.setBanned(entry.getValue().get(i).isBanned());
                forPrint.add(student);
            }
        }
        Collections.sort(forPrint, (o1, o2) -> Integer.compare(o2.getPoints(), o1.getPoints()));
        System.out.println("Results:");
        for (int i = 0; i < forPrint.size(); i++) {
            if (!forPrint.get(i).isBanned()) {
                System.out.printf("%s | %d%n", forPrint.get(i).getName(), forPrint.get(i).getPoints());
            }
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : submissions.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }

    public static int getStudentIndex(List<StudentData> list, String studentName) {
        int idx = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(studentName)) {
                return i;
            }
        }
        return idx;
    }
}
