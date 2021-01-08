package ObjectsAndClasses;

import java.awt.*;
import java.util.*;
import java.util.List;

public class OrderByAge {
    static class Person {
        String name;
        String id;
        int age;

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", getName(), getId(), getAge());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Person> personList = new ArrayList<>();
        while (!input.toLowerCase().equals("end")) {
            String[] inputAsArr = input.split("\\s+");
            Person newPerson = new Person(inputAsArr[0], inputAsArr[1], Integer.parseInt(inputAsArr[2]));
            personList.add(newPerson);
            input = scan.nextLine();
        }
        personList.sort(Comparator.comparing(Person::getAge));
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i).toString());
        }
    }
}
