import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prozor{

    private static String[][] window;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int R = Integer.valueOf(input[0]);
        int S = Integer.valueOf(input[1]);
        int K = Integer.valueOf(input[2]);
        window = new String[R][S];
        for(int i = 0; i<R;i++){
            window[i]= sc.nextLine().split("");
        }
        sc.close();
        int[] mostFlies = {0,0,0};
        List<int[]> fliesHit = new ArrayList<>();
        for(int i = 0; i<=window.length-K;i++){
            for(int j =0; j<=window[i].length-K; j++){
                int[] smash = smashCheck(i, j, K);
                if(smash[0]>mostFlies[0]){
                    mostFlies = smash;
                }
                fliesHit.add(smash);
            }
        }
        drawRacket(mostFlies[1],mostFlies[2],K);
        System.out.println(mostFlies[0]);
        drawMap();

        
    }

    private static void drawMap() {
        String windowString = "";
        for (String[] strings : window) {
            for (String string : strings) {
                windowString += string;
            }
            windowString += "\n";
        }
        System.out.println(windowString);
    }

    private static void drawRacket(int idxY,int idxX, int racketSize){
        for(int i = 0; i<racketSize; i++){
            for(int j= 0; j<racketSize; j++){
                if(i==0 && j==0|| i==0 && j==racketSize-1 || i==racketSize-1 && j== 0 || i==racketSize-1 && j==racketSize-1){
                    window[i+idxY][j+idxX] = "+";
                } else if (i>0 && j<1 || i>0 && j==racketSize-1){
                    window[i+idxY][j+idxX] = "|";
                } else if (i==0 && j>0 || i==racketSize-1 && j>0){
                    window[i+idxY][j+idxX] = "-";
                }
            }
        }
    }

    private static int[] smashCheck(int idxY,int idxX, int racketSize){
        int fliesCount = 0;
        int y = idxY+1;
        int x = idxX+1;
        int sizeSides = racketSize-2;
        for(int i = y; i<y+sizeSides;i++){
            for(int j = x; j<x+sizeSides;j++){
                if(window[i][j].equals("*")){
                    fliesCount += 1;
                }
            }
        }
        int[] racketcount = {fliesCount, idxY, idxX};
        return racketcount;
    }
}