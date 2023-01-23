import java.util.Scanner;

public class NinetyNine{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 1;
        int past = 0;
        System.out.println(x);
        while(x<99){
            past = x;
            int input = sc.nextInt();
            x = input;
            boolean even = (x - past) % 2 == 0 ? true : false; 
            if(x >= 99){
                break;
            } else if(x == 98){
                System.out.println(1+x);
                x +=1;
            } else if(x == 97){
                System.out.println(2+x);
                x +=2;
            } else if(x == 97){
                System.out.println(2+x);
                x +=2;
            } else if(x == 96 && even){
                System.out.println(2+x);
                x +=2;
            } else if(x == 96 && !even){
                System.out.println(1+x);
                x +=1;
            } else {
                System.out.println(2+x);
                x +=2;
            }
        }
    } 
}