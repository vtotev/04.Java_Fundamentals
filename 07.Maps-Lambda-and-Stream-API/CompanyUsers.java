package MapsLambdaStreamAPI;

import java.util.*;

public class CompanyUsers {
    static class Company {
        String companyName;
        List<String> employees = new ArrayList<>();

        public Company(String companyName) {
            this.companyName = companyName;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public List<String> getEmployees() {
            return employees;
        }

        public void setEmployees(List<String> employees) {
            this.employees = employees;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        List<Company> companyList = new ArrayList<>();
        Map<String, List<String>> companyList = new TreeMap<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] cmd = input.split(" -> ");
            List<String> employees = new ArrayList<>();
            if (companyList.containsKey(cmd[0])) {
                employees = companyList.get(cmd[0]);
                companyList.put(cmd[0], employees);
            }
            if (checkEmployee(employees, cmd[1]) == -1) {
                employees.add(cmd[1]);
            }
            companyList.put(cmd[0], employees);
            input = scan.nextLine();
        }
        for (Map.Entry<String, List<String >> entry : companyList.entrySet()) {
            System.out.println(entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.println("-- "+entry.getValue().get(i));
            }
        }
    }

    public static int checkEmployee(List<String> employees, String employeeName) {
        int idx = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employeeName)) {
                return i;
            }
        }
        return idx;
    }

}
