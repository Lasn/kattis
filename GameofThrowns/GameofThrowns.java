import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


public class GameofThrowns{

    Deque<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = bf.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        GameofThrowns gt = new GameofThrowns(n);
        Stack<Integer> moves = new Stack<>();
        String[] theThrows = bf.readLine().split(" ");
        for(int i = 0; i<k;i++){
            String t = theThrows[i];
            if(t.equals("undo")){
                i++;
                k++;
                int tu = Integer.parseInt(theThrows[i]);
                for(int j = 0; j<tu; j++){
                    int move = moves.pop();
                    move *= -1;
                    gt.theThrow(move);
                }

            } else {
                gt.theThrow(Integer.parseInt(t));
                moves.add(Integer.parseInt(t));
            }
        }
        System.out.println(gt.getEgg());


    }

    public GameofThrowns(int n){
        queue = new ArrayDeque<>();
        for(int i = 0;i<n; i++){
            queue.add(i);
        }
    }

    public void theThrow(int m){
        if(m<0){
            m *= -1;
            for(int i = 0; i<m; i++){
                int move = queue.pollLast();
                queue.addFirst(move);
            }
        } else {
            for(int i = 0; i<m; i++){
                int move = queue.pollFirst();
                queue.addLast(move);
              
            }
        }
    }

    public int getEgg() {
        return queue.peek();
    }

}