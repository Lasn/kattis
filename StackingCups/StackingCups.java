import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class StackingCups {

    public static boolean isNumeric(String value){
        return Character.isDigit(value.charAt(0));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx = Integer.valueOf(sc.nextLine());
        Map<Integer,String> cups = new TreeMap<>();
        for(int i =0; i<idx;i++){
            int size = 0;
            String color = "";
            String[] cupInfo = sc.nextLine().split(" ");
            if(isNumeric(cupInfo[0])){
                size = Integer.parseInt(cupInfo[0]);
                color = cupInfo[1];
            } else {
                size = Integer.parseInt(cupInfo[1])*2;
                color = cupInfo[0];
            }
            cups.put(size, color);
        }
        sc.close();
        for (String cup : cups.values()) {
            System.out.println(cup);
        }

    }
}