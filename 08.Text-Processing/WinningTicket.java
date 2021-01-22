package TextProcessing;

import java.util.Scanner;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tickets = scan.nextLine().split(",\\s+");
        char[] symbols = {'@', '#', '$', '^'};
        for (int i = 0; i < tickets.length; i++) {
            String currTicket = tickets[i];
            while (currTicket.contains(" ")) {
                currTicket = currTicket.replace(" ", "");
            }

            if (currTicket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }
            String ticketLeft = currTicket.substring(0, (currTicket.length() / 2));
            String ticketRight = currTicket.substring(currTicket.length() / 2);
            int leftCount = 0;
            int rightCount = 0;
            int charIndex = -1;
            for (int j = 0; j < symbols.length; j++) {
                int counter = checkSymbols(ticketLeft, symbols[j]);
                if (counter >= 6) {
                    leftCount = counter;
                    charIndex = j;
                    rightCount = checkSymbols(ticketRight, symbols[charIndex]);
                    break;
                }
            }
            if (leftCount < 6 || rightCount < 6) {
                System.out.printf("ticket \"%s\" - no match%n", currTicket);
                continue;
            }

            if (leftCount == 10 && rightCount == 10) {
                System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", currTicket, leftCount, symbols[charIndex]);
            } else {
                if (leftCount > rightCount) {
                    System.out.printf("ticket \"%s\" - %d%s%n", currTicket, rightCount, symbols[charIndex]);
                } else {
                    System.out.printf("ticket \"%s\" - %d%s%n", currTicket, leftCount, symbols[charIndex]);
                }
            }
        }
    }

    public static int checkSymbols(String ticket, char symbol) {
        int symbCount = 1;
        for (int i = 1; i < ticket.length(); i++) {
            if (ticket.charAt(i - 1) == symbol && ticket.charAt(i) == symbol) {
                symbCount++;
            }
            if (symbCount < 6 && (ticket.charAt(i - 1) != symbol && ticket.charAt(i) == symbol)) {
                symbCount = 1;
            }
        }
        return symbCount;
    }
}




/*  Version 2

package TextProcessing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tickets = scan.nextLine().split(",\\s+");
        String[] symbols = {"@", "#", "$", "^"};
        Map<String, Integer> charsLeft = new LinkedHashMap<>();
        Map<String, Integer> charsRight = new LinkedHashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            for (String symbol : symbols) {
                charsLeft.put(symbol, 0);
                charsRight.put(symbol, 0);
            }
            String currTicket = tickets[i];
            while (currTicket.contains(" ")) {
                currTicket = currTicket.replace(" ", "");
            }

            if (currTicket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }

            String ticketLeft = currTicket.substring(0, (currTicket.length() / 2));
            String ticketRight = currTicket.substring(currTicket.length() / 2);

            for (int j = 0; j < symbols.length; j++) {
                charsLeft.put(symbols[j], checkSymbols(ticketLeft, symbols[j]));
                charsRight.put(symbols[j], checkSymbols(ticketRight, symbols[j]));
            }
            int leftCount = 0;
            int rightCount = 0;
            String charSymb = "";
            for (Map.Entry<String, Integer> entry: charsLeft.entrySet()) {
                if (leftCount < entry.getValue() && entry.getValue() > 5) {
                    leftCount = entry.getValue();
                    rightCount = charsRight.get(entry.getKey());
                    charSymb = entry.getKey();
                }
            }

            if (leftCount < 6 || rightCount < 6) {
                System.out.printf("ticket \"%s\" - no match%n", currTicket);
                continue;
            }

            if (leftCount >= 10 && rightCount >= 10) {
                System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", currTicket, leftCount, charSymb);
            } else {
                if (leftCount > rightCount) {
                    System.out.printf("ticket \"%s\" - %d%s%n", currTicket, rightCount, charSymb);
                } else {
                    System.out.printf("ticket \"%s\" - %d%s%n", currTicket, leftCount, charSymb);
                }
            }
        }
    }

    public static int checkSymbols(String ticket, String symbol) {
        int symbCount = 1;
        for (int i = 1; i < ticket.length(); i++) {
            if (ticket.charAt(i - 1) == symbol.charAt(0) && ticket.charAt(i) == symbol.charAt(0)) {
                symbCount++;
            }
            if (symbCount < 6 && (ticket.charAt(i - 1) != symbol.charAt(0) && ticket.charAt(i) == symbol.charAt(0))) {
                symbCount = 1;
            }
        }
        return symbCount;
    }
}


 */