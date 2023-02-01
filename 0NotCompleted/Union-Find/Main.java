import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int q = Integer.parseInt(line1[1]);
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i<q; i++){
            String[] line = br.readLine().split(" ");
            String o = line[0];
            int a = Integer.parseInt(line[1]);
            int b = Integer.parseInt(line[2]);
            if(o.equals("?")){
                if(uf.query(a,b)){System.out.println("yes");} else {System.out.println("no");}
            } else {
                uf.union(a,b);
            }
        }
        System.out.println(uf.getCount());
    }
}
