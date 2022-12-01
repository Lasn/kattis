import java.util.Scanner; 
public class Filip{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        String str = input.nextLine();  // Read user input
        String[] arrOfStr = str.split(" ");
        int[] arrOfInt = new int[arrOfStr.length];
        for(int i = 0; i < arrOfStr.length; i++){
            String[] splitString = arrOfStr[i].split("");
            String newstr = splitString[2] + splitString[1] + splitString[0];
            int intReverse = Integer.valueOf(newstr);
            arrOfInt[i] = intReverse;
        }
        System.out.println(arrOfInt[0] > arrOfInt[1] ? arrOfInt[0] : arrOfInt[1]);
        
    }
}