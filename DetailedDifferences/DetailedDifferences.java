import java.util.ArrayList;
import java.util.Scanner;

public class DetailedDifferences {
    public static void main(String[] args) {    
        Scanner input = new Scanner(System.in);
        ArrayList <String> lines = new ArrayList<>();
        int testCase = Integer.valueOf(input.next());
        for(int i = 0; i<testCase;i++){
            lines.add(input.next());
            lines.add(input.next());
        }
        input.close();
        for(int i = 0; i < testCase*2; i+=2){
            String[] line1 = lines.get(i).split("");
            String[] line2 = lines.get(i+1).split("");
            String strLine1 = "";
            String strLine2 = "";
            String strLine3 = "";
            for(int j = 0; j<line1.length; j++) {
                if(line1[j].equals(line2[j])){
                    strLine3 += ".";
                } else {
                    strLine3 += "*";
                }
                strLine1 += line1[j];
                strLine2 += line2[j];
            }

            System.out.println(strLine1);
            System.out.println(strLine2);
            System.out.println(strLine3);
            System.out.println();
          

        }
        
    }
    
}