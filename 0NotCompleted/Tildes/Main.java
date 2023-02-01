public class Main {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in);
        int n = k.getInt();
        int q = k.getInt();
        Tides t = new Tides(n);
        for(int i = 0; i<q;i++){
            String o = k.getWord();
            int a = k.getInt()-1;
            switch(o){
                case "s": System.out.println(t.getSize(a)); break;
                case "t": t.union(a, k.getInt()-1); break;
            }

        }
    }
}
