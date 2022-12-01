import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static ContinuousMedian treads[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        treads = new ContinuousMedian[t];
        for(int i = 0; i<t; i++){
            int n = Integer.valueOf(br.readLine());
            String[] list = br.readLine().split(" ");
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
