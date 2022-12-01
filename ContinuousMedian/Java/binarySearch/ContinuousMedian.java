import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContinuousMedian{

    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        int t = sc.getInt();
        for(int i = 0; i<t; i++){
            long n = sc.getLong();
            List<Long> setNum = new ArrayList<>();
            long sum = 0;
            for(int j= 0; j<n;j++ ){
                long a = sc.getLong();
                if(j!=0 && (a<setNum.get(j-1))){
                    int idx = Collections.binarySearch(setNum, a);
                    if(idx > 0){
                        setNum.add(idx, a);
                    } else {
                        idx = (idx*-1)-1;
                        if(idx < 0) idx = 0; 
                        setNum.add(idx, a);
                    }
                } else {
                    setNum.add(a);
                }
                if(j%2!=0){
                    long m = (setNum.get(j/2)+setNum.get((j/2)+1))/2;
                    sum += m;

                } else {
                    sum += setNum.get(j/2);
                }
            }
            System.out.println(sum);
        }
    }
}