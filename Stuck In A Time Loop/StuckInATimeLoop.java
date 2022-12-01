import java.util.Scanner;

public class StuckInATimeLoop{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        String str = "Abracadabra";
        for(int i = 0; i<num; i++){
            String newnum = String.valueOf(i +1);
            System.out.println(newnum + " " + str);
        }
    }
}