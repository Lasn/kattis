import java.util.Scanner;

public class Tarifa{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mb = sc.nextInt();
        int index = sc.nextInt();
        int dataLeft = mb;
        for(int i = 0; i< index;i++){
            int n = sc.nextInt();
            dataLeft += mb-n;
        }
        System.out.println(dataLeft);
    }
}