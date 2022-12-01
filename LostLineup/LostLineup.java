import java.util.Scanner;

public class LostLineup{

    public static int[] importData(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] line = new int[n];
        line[0]=1;
        for(int i = 1; i<n; i++){
            line[1+sc.nextInt()] = i+1;
        }
        return line;


    }
    public static void main(String[] args) {
        int[] lineUp = importData();
        String line = "";
        for (int i : lineUp) {
            line += i + " ";
        }
        System.out.println(line);
    }
}