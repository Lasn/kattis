import java.util.Scanner;

public class FizzBuzz{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        for(int i = 1; i<= n; i++){
            String str = "";
            if(i%x==0){
                str += "Fizz";
            } 
            if(i%y==0){
                str += "Buzz";
            } 
            if(str == ""){
                str = String.valueOf(i);
            }
            System.out.println(str);

        }
    }
}