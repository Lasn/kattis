import java.util.ArrayList;
import java.util.Arrays;

public class EmagEhtHtiwEmPleh {

    private String[][] board = new String[8][8];

    public void printBoard() {
        int rowIdx = 0;
        for (String[] row : board) {
            int i = 0;
            System.out.println("+---+---+---+---+---+---+---+---+");
            String line = "|";
            for (String collon : row) {
                boolean white = (rowIdx + i)%2==0 ? true : false;
                String space = white ? "." : ":";
                if(collon != null){
                    line += space + collon + space + "|";
                } else {
                    line += space + space + space + "|";
                }
                i++;
            }
            System.out.println(line);
            rowIdx++;

        }
        System.out.println("+---+---+---+---+---+---+---+---+");
    }
    
    public void importPositions(String positions) {
        String[] input = positions.split("\n");
        for (String type : input) {
            String[] positionsArr = type.split(" |,");
            if(positionsArr[0].startsWith("White")){
                System.out.println();
                positionsToBoard(positionsArr,"White");
            }
            if(positionsArr[0].startsWith("Black")){
                System.out.println();
                positionsToBoard(positionsArr,"Black");
            }
        }
    }

    private void positionsToBoard(String[] positionsArr, String color) {
        ArrayList<String> colonsIdx = new ArrayList<>();
        String[] colons = {"a","b","c","d","e","f","g","h"};
        Arrays.stream(colons).forEach(x -> colonsIdx.add(x));
        boolean white = color.equals("White") ? true : false;
        for (String p : positionsArr) {
            String[] pArr = p.split("");
            String key = white ? pArr[0] : pArr[0].toLowerCase();
            if(p.length() == 3){
                int colon = colonsIdx.indexOf(pArr[1]);
                int row = 8 - Integer.parseInt(pArr[2]);
                this.board[row][colon] = key;
            }
            if(p.length() == 2){
                key = white ? "P" : "p";
                int colon = colonsIdx.indexOf(pArr[0]);
                int row = 8 - Integer.parseInt(pArr[1]);
                this.board[row][colon] = key;
            }
        }
    }
}
