import java.util.Scanner;

public class ElectricalOutlets{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i =0; i<n;i++){
            int k = sc.nextInt();
            int s = 0;
            for(int j = 0; j<k;j++){
                s += sc.nextInt();
            }
            System.out.println(s-k+1);
        }
        sc.close();
    }
}