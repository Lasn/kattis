import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnionFind{

    private Integer[] id;

    public static void main(String[] args) throws IOException {
        UnionFind uf = new UnionFind();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        Integer n = Integer.parseInt(firstLine[0]);
        Integer q = Integer.parseInt(firstLine[1]);
        uf.id = new Integer[n];
    
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

    private Integer find(Integer number){
        Integer parent = id[number];
        if(parent != null){find(parent);}
        return parent == null ? number : parent;
    }

    private void query(Integer s, Integer t) {
        Integer rootS = find(s);
        Integer rootT = find(t);

        if(rootS.equals(rootT)){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private void union(Integer s, Integer t) {
        Integer rootS = find(s);
        Integer rootT = find(t);

        if(!rootS.equals(rootT)){
            id[rootS] = rootT;
            id[s] = rootT;
        }
    }

}