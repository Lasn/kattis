import java.util.Scanner;

public class ColdputerScience{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        int count = 0;
        for(int i = 0; i<index; i++){
            int num = sc.nextInt();
            if(num <0){
                count += 1;
            }
        }
        System.out.println(count);


    }
}