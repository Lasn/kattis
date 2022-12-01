
public class ShatteredCake{
    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        int W = sc.getInt();
        int N = sc.getInt();
        int size = 0;
        for(int i = 0; i<N;i++){
            int w = sc.getInt();
            int l = sc.getInt();
            size += w*l;
        }
        System.out.println(size/W);
        sc.close();
    }
}