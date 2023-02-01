public class Main {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in);
        int n = k.getInt();
        int q = k.getInt();
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i<q; i++){
            String o = k.getWord();
            int a = k.getInt();
            int b = k.getInt();
            switch(o){
                case "?": if(uf.query(a,b)){System.out.println("yes");} else {System.out.println("no");}; break;
                case "=": uf.union(a,b); break;
            }
        }
    }
}
