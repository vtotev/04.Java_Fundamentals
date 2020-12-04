package BasicExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int persons = Integer.parseInt(scan.nextLine());
        String grouptype = scan.nextLine();
        String day = scan.nextLine();
        double price = 0.00;
        switch (day.toLowerCase()) {
            case "friday":
                switch (grouptype.toLowerCase()){
                    case "students":
                        price = persons * 8.45;
                        if (persons >= 30)
                            price = price * 0.85;
                        break;
                    case "business":
                        if (persons >= 100)
                            price = price = (persons - 10) * 10.9;
                        else  price = persons * 10.9;
                        break;
                    case "regular":
                        price = persons * 15.00;
                        if (persons >= 10 && persons <= 20)
                            price = price * 0.95;
                        break;
                }
                break;

            case "saturday":
                switch (grouptype.toLowerCase()){
                    case "students":
                        price = persons * 9.80;
                        if (persons >= 30)
                            price = price * 0.85;
                        break;
                    case "business":
                        if (persons >= 100)
                            price = price = (persons - 10) * 15.6;
                        else  price = persons * 15.6;
                        break;
                    case "regular":
                        price = persons * 20.00;
                        if (persons >= 10 && persons <= 20)
                            price = price * 0.95;
                        break;
                }
                break;

            case "sunday":
                switch (grouptype.toLowerCase()){
                    case "students":
                        price = persons * 10.46;
                        if (persons >= 30)
                            price = price * 0.85;
                        break;
                    case "business":
                        if (persons >= 100)
                            price = price = (persons - 10) * 16.0;
                        else  price = persons * 16.0;
                        break;
                    case "regular":
                        price = persons * 22.50;
                        if (persons >= 10 && persons <= 20)
                            price = price * 0.95;
                        break;
                }
                break;
        }

        System.out.printf("Total price: %.2f", price);
    }
}
