package ObjectsAndClasses;

import java.nio.file.LinkPermission;
import java.util.*;

public class OpinionPoll {

    static class Person {
        String name;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<Person> personsList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split(" ");
            Person singlePerson = new Person(input[0], Integer.parseInt(input[1]));
            personsList.add(singlePerson);
        }
        Collections.sort(personsList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (int i = 0; i < personsList.size(); i++) {
            if (personsList.get(i).getAge() > 30)
                System.out.printf("%s - %d%n", personsList.get(i).getName(), personsList.get(i).getAge());
        }
    }
}
