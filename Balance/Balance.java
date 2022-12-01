import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Balance{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split("");
        sc.close();
        if(pTest(line)){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean pTest(String[] line) {
        int openP = 0;
        int openB = 0;
        List<String> test = new ArrayList<>();
        for (String cha : line) {
            int size = test.size();
            if((cha.equals(")") ||cha.equals("]")) && test.isEmpty()){
                return false;
            }
            switch(cha){
                case "(" : test.add("("); openP++;  break;
                case "[" : test.add("["); openB++; break;
                case ")" : if(test.get(size-1).equals("(")){test.remove(size-1); openP--;} else {return false;};  break;
                case "]" : if(test.get(size-1).equals("[")){test.remove(size-1); openB--;} else {return false;};  break;
            }
        }
        if(openB==0 && openP==0){
            return true;
        } else {
            return false;
        }
        
    }
}