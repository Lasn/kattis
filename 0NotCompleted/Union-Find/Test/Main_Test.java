
public class Main_Test{
    public static void main(String[] args) {
        int n = StdIn.readInt();
        UnionFind uf = new UnionFind(n);
    
        for(int i = 0; i<900; i++){
            int a = StdIn.readInt();
            int b = StdIn.readInt();
            uf.union(a, b);
        }

        System.out.println(uf.getCount());
    }
}