import java.util.Scanner;

public class OddEcho{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        for(int i = 0; i<n; i++){
            String str = sc.nextLine();
            if(i%2 == 0){
                System.out.println(str);
            }
        }
        sc.close();
    }
}