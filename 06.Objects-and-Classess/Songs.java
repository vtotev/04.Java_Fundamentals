package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    static class song {
        String typeList;
        String name;
        String time;

        public song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getTypeList() {
            return typeList;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<song> songsList = new ArrayList<>();
        List<String> typeSongsList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split("_");
            song newSong = new song(input[0], input[1], input[2]);
            songsList.add(newSong);
            typeSongsList.add(input[0]);
        }
        String input = scan.nextLine();
        if (input.equals("all")) {
            for (int i = 0; i < songsList.size(); i++) {
                System.out.println(songsList.get(i).name);
            }
        } else {
            for (int i = 0; i < songsList.size(); i++) {
                if (input.equals(songsList.get(i).typeList)) {
                    System.out.println(songsList.get(i).name);
                }
            }
        }
    }
}
