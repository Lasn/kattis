import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tides{

    private static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int q = Integer.parseInt(firstLine[1]);
        list = new int[n];
        for(int i = 0; i<n; i++){
            list[i] = i;
        }
    
        for(int i = 0; i<q; i++){
            String[] line = br.readLine().split(" ");

            switch(line[0]){
                case "s" : query(Integer.parseInt(line[1])-1);  break;
                case "t" : union(Integer.parseInt(line[1])-1, Integer.parseInt(line[2])-1); break;
            }
        }
    }

    private static int find(int number){
        int parent = list[number];
        if(parent != number){find(parent);}
        return parent;
    }

    private static void query(int s) {
        int rootS = find(s);
        int count = 0;
        for (int i : list) {
            if(i == rootS){count++;}
        }
        System.out.println(count);
    }

    private static void union(int s, int t) {
        int rootS = find(s);
        int rootT = find(t);

        if(rootS != rootT){
            list[rootT] = rootS;
         }
    }

}
