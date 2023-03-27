import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ICantheDataStructure{


    public static void main(String[] args) throws NumberFormatException, IOException {
        ICantheDataStructure ds = new ICantheDataStructure();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            for(int i = 0; i<n; i++){
                int c = sc.nextInt();
                int x = sc.nextInt();
                switch(c){
                    case 1: ds.add(x); break;
                    case 2: ds.remove(x); break;
                }
            }
            System.out.println(ds.toString());
            ds.reset();
        
        }
        sc.close();
        
    }



    private Stack<Integer> stack;
    private Queue<Integer> queue;
    private Queue<Integer> queueH;

    private boolean s = true;
    private boolean q = true;
    private boolean qh = true;
   

    public ICantheDataStructure(){
        stack = new Stack<>();
        queue = new LinkedList<>();
        queueH = new PriorityQueue<>(Collections.reverseOrder());
       
    }

    public void reset() {
        stack = new Stack<>();
        queue = new LinkedList<>();
        queueH = new PriorityQueue<>(Collections.reverseOrder());
      
        s = true;
        q = true;
        qh = true;
       
    }

    public String toString() {
        if(s && !q && !qh){return "stack";}
        if(!s && q && !qh){return "queue";}
        if(!s && !q && qh){return "priority queue";}
        if(notSure()){return "not sure";}
        else {return "impossible";}
    }

    private boolean notSure(){
        int count = 0;
        if(s){count++;}
        if(q){count++;}
        if(qh){count++;}


        if(count > 1){return true;}
        else {return false;}
    }

    public void add(Integer i) {
        stack.push(i);
        queue.offer(i);
        queueH.offer(i);
  
    }

    public void remove(Integer i) {
        try{
            if(!stack.pop().equals(i)){s = false;}
            if(!queue.remove().equals(i)){q = false;}
            if(!queueH.remove().equals(i)){qh = false;}
          
    
        } catch (Exception e){
            s = false;
            q = false;
            qh = false;
     
        }
        
        

    
    }

    


}