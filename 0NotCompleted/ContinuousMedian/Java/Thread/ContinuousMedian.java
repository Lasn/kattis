import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContinuousMedian extends Thread{

    private long[] nums;
    private int thread;
    private long sum;

    public ContinuousMedian(int thread, long[] nums) {
        this.nums = nums;
        this.thread = thread;
    }

    public long getSum() {
        return sum;
    }

    public int getThread(){
        return thread;
    } 

    public void run(){
        long n = nums.length;
        List<Long> setNum = new ArrayList<>();
        long sum = 0;
        for(int j= 0; j<n;j++ ){
            long a = nums[j];
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
        this.sum = sum;
        
    }

}
