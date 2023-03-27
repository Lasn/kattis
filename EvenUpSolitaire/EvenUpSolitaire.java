import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EvenUpSolitaire{

    Stack<Integer> stack;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(bf.readLine());
        List<Integer> list = new ArrayList<>();
        for (String num : bf.readLine().split(" ")) {
            list.add(Integer.parseInt(num));
        }
        EvenUpSolitaire eup = new EvenUpSolitaire(list);
        System.out.println(eup.getSize());
        
    }

    public void addToStack(Integer newInt) {
        if(stack.empty()){
            stack.add(newInt);
            return;
        }

        int last = stack.lastElement();
        if((last+newInt) % 2 == 0){
            stack.pop();
        } else {
            stack.push(newInt);
        }

    }
    

    public EvenUpSolitaire(List<Integer> list) {
        stack = new Stack<>();
        for (Integer integer : list) {
            addToStack(integer);
        }
    } 

    public int getSize() {
        return stack.size();
    }


}