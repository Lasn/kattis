

public class Thanos{
    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        long n = sc.getLong();
        for(int i = 0; i<n;i++){
        long p = sc.getLong();
        long r = sc.getLong();
        long f = sc.getLong();
        slow(p, r, f);
        }
        sc.close();
        
    }


    public static void slow(long p, long r, long f) {
            long years = 0;
            while(p<=f){
                p *= r;
                years++;
        }
        System.out.println(years);
    }

}