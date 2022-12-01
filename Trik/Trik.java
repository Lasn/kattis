import java.util.Scanner;

public class Trik{

    private static String[] cups = {"X",".","."};

    private static void swap(String move){ 
        switch(move){
            case "A":
            String hold1 = cups[0];
            cups[0]=cups[1];
            cups[1]=hold1;
            break;
            case "B":
            String hold2 = cups[1];
            cups[1]=cups[2];
            cups[2]=hold2;
            break;
            case "C":
            String hold3 = cups[0];
            cups[0]=cups[2];
            cups[2]=hold3;
            break;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("");
        sc.close();
        for (String string : input) {
            swap(string);
        }
        for (int i = 0; i < cups.length; i++) {
            if(cups[i].equals("X")){
                System.out.println(i+1);
            }
        }

    }
}