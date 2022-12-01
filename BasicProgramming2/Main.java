import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BasicProgramming2 bp = new BasicProgramming2();
        int n = 200000;
        String[] a = new String[n];
        for(int i = 1; i<n+1; i++){
            //a[i-1] = "1000000";
            a[i-1] = String.valueOf(i);
            //a[i-1] = String.valueOf(new Random().nextInt(Integer.MAX_VALUE));
        }
        //a[199999] = "1";
        long s = System.nanoTime();
        bp.switchC(4,a);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000);
    }
}
