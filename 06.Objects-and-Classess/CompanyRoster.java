package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CompanyRoster {

    static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email;
        int age;

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public String getPosition() {
            return position;
        }

        public String getDepartment() {
            return department;
        }

        public String getEmail() {
            return email;
        }

        public int getAge() {
            return age;
        }

        public Employee(String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<String> departments = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split("\\s++");
            if (!departments.contains(input[3])) {
                departments.add(input[3]);
            }
            String email = "n/a";
            int age = -1;
            if (input.length == 4) {
//
            } else if (input.length == 5) {
                if (input[4].contains("@")) {
                    email = input[4];
                } else {
                    age = Integer.parseInt(input[4]);
                }
            } else {
                if (input[4].contains("@")) {
                    email = input[4];
                    age = Integer.parseInt(input[5]);
                } else {
                    email = input[5];
                    age = Integer.parseInt(input[4]);
                }
            }
            Employee newEmployee = new Employee(input[0], Double.parseDouble(input[1]), input[2],
                    input[3], email, age);
            employeeList.add(newEmployee);

        }
        List<Double> avgSalary = new ArrayList<>();
        for (int i = 0; i < departments.size(); i++) {
            avgSalary.add(0.0);
            int emplCount = 0;
            for (int j = 0; j < employeeList.size(); j++) {
                if (employeeList.get(j).getDepartment().equals(departments.get(i))) {
                    avgSalary.set(i, avgSalary.get(i) + employeeList.get(j).getSalary());
                    emplCount++;
                }
            }
            avgSalary.set(i, (avgSalary.get(i) / emplCount));
        }
        int greaterIndex = -1;
        double avgSlr = 0.0;
        for (int i = 0; i < avgSalary.size(); i++) {
            if (avgSalary.get(i) >= avgSlr) {
                avgSlr = avgSalary.get(i);
                greaterIndex = i;
            }
        }
        employeeList.sort(Comparator.comparing(Employee::getSalary).reversed());
        System.out.printf("Highest Average Salary: %s%n", departments.get(greaterIndex));

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getDepartment().equals(departments.get(greaterIndex))) {
                System.out.printf("%s %.2f %s %d%n", employeeList.get(i).getName(),
                        employeeList.get(i).getSalary(),
                        employeeList.get(i).getEmail(),
                        employeeList.get(i).getAge());
            }
        }
    }
}
