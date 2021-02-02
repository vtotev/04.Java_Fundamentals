package ExamPrep;

import java.util.*;

public class ThePianist {
    static class Piece {
        String piece;
        String composer;
        String key;
        public Piece(String piece, String composer, String key) {
            this.piece = piece;
            this.composer = composer;
            this.key = key;
        }

        public String getPiece() {
            return piece;
        }

        public void setPiece(String piece) {
            this.piece = piece;
        }

        public String getComposer() {
            return composer;
        }

        public void setComposer(String composer) {
            this.composer = composer;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Piece> pieceList = new ArrayList<>();
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split("\\|");
            Piece newPiece = new Piece(input[0], input[1], input[2]);
            pieceList.add(newPiece);
        }
        String input = scan.nextLine();
        while (!input.equals("Stop")) {
            String[] cmd = input.split("\\|");
            String pieceName = cmd[1];
            int pieceIndex = getPieceIndex(pieceList, pieceName);
            switch (cmd[0]) {
                case "Add":
                    if (pieceIndex != -1) {
                        System.out.printf("%s is already in the collection!%n", pieceName);
                    } else {
                        Piece newPieceToAdd = new Piece(pieceName, cmd[2], cmd[3]);
                        pieceList.add(newPieceToAdd);
                        System.out.printf("%s by %s in %s added to the collection!%n", pieceName, cmd[2], cmd[3]);
                    }
                    break;

                case "Remove":
                    if (pieceIndex != -1) {
                        pieceList.remove(pieceIndex);
                        System.out.printf("Successfully removed %s!%n", pieceName);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                    }
                    break;

                case "ChangeKey":
                    if (pieceIndex != -1) {
                        pieceList.get(pieceIndex).setKey(cmd[2]);
                        System.out.printf("Changed the key of %s to %s!%n", pieceName, cmd[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                    }
                    break;

            }
            input = scan.nextLine();
        }
        Collections.sort(pieceList, new Comparator<Piece>() {
            @Override
            public int compare(Piece o1, Piece o2) {
                int compName = o1.getPiece().compareTo(o2.getPiece());
                if (compName != 0) {
                    return compName;
                }
                return o1.getComposer().compareTo(o2.getComposer());
            }
        });
        for (int i = 0; i < pieceList.size(); i++) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", pieceList.get(i).getPiece(),
                    pieceList.get(i).getComposer(), pieceList.get(i).getKey());
        }
    }

    public static int getPieceIndex(List<Piece> pieces, String pieceName) {
        int indx = -1;
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getPiece().equals(pieceName)) {
                return i;
            }
        }
        return indx;
    }
}
