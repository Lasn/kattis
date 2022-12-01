import java.util.Scanner;

public class Digits{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            String input = sc.nextLine();
            if(input.equals("END")){
                break;
            }
            // find length of digits + first digit
            // count is 10 * times digits
            int count = 2;
            long left = input.length();
            while(left > 1){
                left = String.valueOf(left).length();
                count += 1;
            }
            if(input.length() == 1){
                if(Integer.valueOf(input) == 1){
                    count = 1;
                }
            }
            System.out.println(count);
        }
        sc.close();  
    }
}