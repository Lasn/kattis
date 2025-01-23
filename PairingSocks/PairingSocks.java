import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PairingSocks{

    private Stack<Integer> pile;
    private Stack<Integer> auxiliaryPile;
    private boolean isPossible;

    public static void main(String[] args) throws IOException {
        int moves = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine())*2;
        PairingSocks ps = new PairingSocks(bf.readLine().split(" "));
        while(!ps.pileIsEmpty()){
            if((!ps.auxiliaryPileIsEmpty()) && ps.isEqual()){ps.pair(); moves++;}
            else {
                ps.moveToAuxiliaryPile();
                moves++;
            }
        }
        if(ps.pileIsEmpty() && ps.auxiliaryPileIsEmpty()){System.out.println(moves);}
        else {System.out.println("impossible");}
    }

    public PairingSocks(String[] socks){
        pile = new Stack<>();
        auxiliaryPile = new Stack<>();
        for(int i = socks.length-1; i>-1; i--){
            pile.add(Integer.parseInt(socks[i]));
        }
            
    }

    public boolean isPossible() {
        return isPossible;
    }

    public void moveToAuxiliaryPile() {
        auxiliaryPile.push(pile.pop());
    }

    public void moveToPile() {
        pile.push(auxiliaryPile.pop());
    }

    public boolean isEqual() {
        if(pileIsEmpty() || auxiliaryPileIsEmpty()){return false;}
        return pile.peek().equals(auxiliaryPile.peek());
    }

    public void pair() {
        pile.pop();
        auxiliaryPile.pop();
    }

    public boolean pileIsEmpty() {
        return pile.isEmpty();
    }

    public boolean auxiliaryPileIsEmpty() {
        return auxiliaryPile.isEmpty();
    }

    public void SetIsPossible(boolean b) {
        isPossible=b;
    }



}


