import java.util.Scanner;

public class SodaSlurper{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int emptyBottles = sc.nextInt();
        int found = sc.nextInt();
        emptyBottles += found;
        int prize = sc.nextInt();
        sc.close();
        int drankSodas = 0;
        while(emptyBottles>= prize){
        emptyBottles -= prize;
        drankSodas++;
        emptyBottles++;
        }
     System.out.println(drankSodas);
    }
}