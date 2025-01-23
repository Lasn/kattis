import java.util.Scanner;

public class Sibice{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();
        double C = Math.sqrt(Math.pow(W,2)+Math.pow(H,2));
        for(int i = 0; i < N; i++){
            int match = sc.nextInt();
            if(match <= C){
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
        sc.close();
    }
}