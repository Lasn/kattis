import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        Integer n = Integer.parseInt(firstLine[0]);
        Integer q = Integer.parseInt(firstLine[1]);
        UnionFind uf = new UnionFind(n);
    
        for(Integer i = 0; i<q; i++){
            String[] line = br.readLine().split(" ");
            Integer a = Integer.parseInt(line[1]);
            Integer b = Integer.parseInt(line[2]);

            switch(line[0]){
                case "?" : uf.query(a, b);  break;
                case "=" : uf.union(a, b); break;
            }
        }
    }
}