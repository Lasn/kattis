import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Statistics{

    private static List<Integer> cases;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx = 1;
        while(sc.hasNextInt()){
            cases = new ArrayList<>();
            String output = "Case ";
            int n = sc.nextInt();
            for(int i = 0; i<n;i++){
                cases.add(sc.nextInt());
            }
            output += idx + ": ";
            idx++;
            Collections.sort(cases);
            output += cases.get(0) + " ";
            output += cases.get(cases.size()-1) + " ";
            output += cases.get(cases.size()-1) - cases.get(0);
            System.out.println(output);



        }

    }
}