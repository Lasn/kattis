import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AClassyProblem{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> people = new HashMap<>();
        int n = Integer.parseInt(bf.readLine());
        for(int i = 0; i<n; i++){
            int t = Integer.parseInt(bf.readLine());
            people = new HashMap<>();
            for(int j = 0; j<t; j++){
                String[] line = bf.readLine().split(": ");
                people.put(line[0], score(line[1]));
            }
            people.entrySet().stream().sorted((x1,x2) -> compareScore(x2.getKey(), x2.getValue(), x1.getKey(), x1.getValue()))
            .forEach(x -> System.out.println(x.getKey()));
            System.out.println("=".repeat(30));
        }
    }

    private static Integer score(String s){
        String[] line = s.split("-| class");
        int score = 0;
        int classes = 10;
        for(int i = line.length-1; i>=0;i--){
            switch(line[i]){
                case "upper": score += Math.pow(3, classes); break;
                case "middle":score += 0; break;
                case "lower": score -= Math.pow(3, classes); break;
            }
            classes--;
        }
        return score;
    }

    private static int compareScore(String n1, int i1, String n2, int i2) {
        if(i1<i2){return -1;}
        else if(i1>i2){return 1;}
        else{return n2.compareTo(n1);}
    }

}