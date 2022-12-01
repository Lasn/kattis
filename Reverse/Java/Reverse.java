import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Reverse{
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(sc.readLine());
        int[] list = new int[n];
        for(int i = 0; i<n;i++){
            list[i] = Integer.valueOf(sc.readLine());
        }
        sc.close();
        for(int i = n-1; i>-1; i--){
            System.out.println(list[i]);
        }
        
        
    }
}