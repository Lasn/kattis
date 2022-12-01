import java.util.Scanner;

public class ReversedBinaryNumbers{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.close();
        int decNum = reverseBitoDec(input);
        System.out.println(decNum);
    }   

    public static int reverseBitoDec(int num) {
        int powerOfTwo = 0;
        String binaryofInput = "";
        for(int i =0; i<40; i++){
            if(num < Math.pow(2, i)){
                powerOfTwo = i;
                break;
            }
        }    
        int intLeft = 0;
        intLeft = num;
        for(int i=powerOfTwo; i > 0; i--){
            if(intLeft % 2 == 0){
                binaryofInput += "0";
                intLeft = (intLeft/2);
            } else {
                binaryofInput += "1";
                intLeft = (intLeft/2);
            }
        }

        String[] biArStrings = binaryofInput.split("");
        int newInt = 0;
        for(int i =0; i<powerOfTwo; i++){
            int x = Integer.valueOf(biArStrings[i]);
            double biInt = Math.pow(2, (powerOfTwo-1)-i);
            newInt += biInt * x;
        }
        return Integer.valueOf(newInt);
    }

   
}
