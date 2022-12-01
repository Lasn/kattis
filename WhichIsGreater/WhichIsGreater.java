import java.util.Scanner;  // Import the Scanner class

public class WhichIsGreater{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        String str = input.nextLine();  // Read user input
        String[] arrOfStr = str.split(" ");
        int[] arrOfInt = new int[arrOfStr.length];
        for(int i = 0; i < arrOfStr.length; i++){
        arrOfInt[i] = Integer.valueOf(arrOfStr[i]);
        }
        if(arrOfInt[0]>arrOfInt[1]){
            System.out.println(1);
        } else{
            System.out.println(0);
        }
        
    }
}
