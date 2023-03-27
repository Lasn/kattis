import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class ContinuousMedian{

    private PriorityQueue<Integer> p1;
    private PriorityQueue<Integer> p2;
    private PriorityQueue<Integer> p3;

    public ContinuousMedian(){
        p1 = new PriorityQueue<>((x1,x2) -> x2-x1);
        p2 = new PriorityQueue<>();
        p3 = new PriorityQueue<>((x1,x2) -> x2-x1);


    }

    public void addInt(int i) {
        if(p1.isEmpty() || p2.isEmpty()){init(i); return;}

       
        if(p1.size() < p2.size() || p1.size() == p2.size() ){
            if(p1.peek() >= i || p2.peek() >= i){p1.add(i); return;}
            int move = p2.poll();
            p2.add(i);
            p1.add(move);
        } else {
            if(p2.peek() <= i || p1.peek() <= i){p2.add(i); return;}
            int move = p1.poll();
            p1.add(i);
            p2.add(move);
        }
    }

    private void init(int i){
        if(p1.isEmpty()){p1.add(i); return;}
        if(p1.peek() <= i){p2.add(i); return;}
        int move = p1.poll();
        p1.add(i);
        p2.add(move);
    }


    public int getMedian(){
        if(p2.isEmpty()){return p1.peek();}
        if(p1.size() < p2.size()) return p2.peek();
        if(p1.size() > p2.size()) return p1.peek();
        return ((p1.peek() + p2.peek())/2);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for(int i = 0; i< t; i++){
            long sum = 0;
            ContinuousMedian cm = new ContinuousMedian();
            int n = Integer.parseInt(bf.readLine());
            String[] line = bf.readLine().split(" ");
            for (String s : line) {
                cm.addInt(Integer.parseInt(s));
                sum += cm.getMedian();
            }
            System.out.println(sum);
        }
       
    }
}