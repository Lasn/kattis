import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelpMeWithTheGame{

    private Map<String,List<Pieces>> black;
    private Map<String,List<Pieces>> white;
    private final String[] pieces = {"K","Q","R","B","N","P"};

    public HelpMeWithTheGame(){
        createMap();
    }

    private void createMap() {
        black = new HashMap<>();
        white = new HashMap<>();
        for (String string : pieces) {
            black.put(string,new ArrayList<>());
            white.put(string,new ArrayList<>());
        }
    }

    private boolean isLowerCase(String c) {
        if(c == ""){
            return false;
        }
        return Character.isLowerCase(c.charAt(0));   
    }


    public String printPieces() {
        String white = "White: ";
        for (String k : pieces) {
            List<Pieces> list = this.white.get(k);
            list.sort(Comparator.comparing(Pieces::getRow).thenComparing(Pieces::getColon));
                               
            for (Pieces p : list) {
                if(!k.equals("P")){
                    white += k;
                }
                white += p.getColon() + p.getRow() + ",";
            }
        }
        white = white.substring(0, white.length()-1);

        String black = "Black: ";
        for (String k : pieces) {
            List<Pieces> list = this.black.get(k);
            list.sort(Comparator.comparing(Pieces::getRow).reversed().thenComparing(Pieces::getColon));

            for (Pieces p : list) {
                if(!k.equals("P")){
                    black += k;
                }
                black += p.getColon() + p.getRow() + ",";
            }
        }
        black = black.substring(0, black.length()-1);
        System.out.println(white + "\n" + black);
        return white + "\n" + black;
    }

    private List<String> lineSplit(String line) {
        List<String> newArr = new ArrayList<>();
        String[] lineArr = line.split(".?\\|.?");
        for (String string : lineArr) {
            if(string.length() != 0){
                newArr.add(string);
            }
        }
        return newArr;
    }



    public void importMap(String board) {
        int lineIdx = 8;
        String[] rowIdx = {"a","b","c","d","e","f","g","h"};
        for(String line : board.split("\n")){
            if(line.startsWith("|")){
                List<String> lineArr = lineSplit(line);
                for(int i = 0; i<8;i++){
                    String cha = lineArr.get(i);
                    String key = cha.toUpperCase();
                    if(isLowerCase(cha) && black.containsKey(key)){
                        String row = rowIdx[i];
                        Pieces p = new Pieces(row, lineIdx);
                        black.get(key).add(p);
                    }
                    if((!isLowerCase(cha)) && white.containsKey(key)){
                        String row = rowIdx[i];
                        Pieces p = new Pieces(row, lineIdx);
                        white.get(key).add(p);
                    }
                }
                lineIdx--;
            }
        }
    }
}