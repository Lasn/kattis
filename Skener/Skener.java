import java.util.ArrayList;
import java.util.Scanner;

public class Skener{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] intInput = sc.nextLine().split(" ");
        int[] intVal = new int[4];
        for (int i = 0;i<4;i++) {
            intVal[i]=Integer.valueOf(intInput[i]);
        }
        ArrayList<String> matrix = new ArrayList<>();
        for(int i = 0; i < intVal[0]; i++){
            String[] line = sc.next().split("");
            String newLine = "";
            for (String string : line) {
                String newString = "";
                newString = string.repeat(intVal[3]);
                newLine += newString;
            }
            for(int j=0;j<intVal[2];j++)
                matrix.add(newLine);
        }
        sc.close();
        for (String line : matrix) {
            System.out.println(line);
            
        }

    }
}