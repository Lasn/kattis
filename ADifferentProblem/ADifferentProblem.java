import java.util.Scanner;

public class ADifferentProblem{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLong()){
            long x = sc.nextLong();
            long y = sc.nextLong();
            if(x < y){System.out.println(y-x);}
            else{System.out.println(x-y);}
        }
        sc.close();
    }
}