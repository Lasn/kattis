public class Main {

    private static ContinuousMedian treads[];

    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        int t = sc.getInt();
        treads = new ContinuousMedian[t];
        for(int i = 0; i<t; i++){
            int n = sc.getInt();
            long[] list = new long[n];
            for(int j= 0; j<n; j++){
                list[j] = sc.getLong();
            }
            ContinuousMedian thr = new ContinuousMedian(i, list);
            thr.start();
            treads[i] = thr;
        }
        for (ContinuousMedian thr : treads) {
            while(thr.isAlive()){
            }
            System.out.println(thr.getSum());
        }   
    }
}
