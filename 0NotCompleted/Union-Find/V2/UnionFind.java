import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnionFind{

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
            int a = Integer.parseInt(line[1]);
            int b = Integer.parseInt(line[2]);

            switch(line[0]){
                case "?" : query(a, b);  break;
                case "=" : union(a, b); break;
            }
        }
    }

    private static int find(int number){
        int parent = list[number];
        if(parent != number){find(parent);}
        return parent;
    }

    private static void query(int s, int t) {
        int rootS = find(s);
        int rootT = find(t);

        if(rootS == rootT){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static void union(int s, int t) {
        int rootS = find(s);
        int rootT = find(t);

        if(rootS != rootT){
            list[rootT] = rootS;
         }
    }

}