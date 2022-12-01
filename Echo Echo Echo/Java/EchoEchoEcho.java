import java.util.Scanner;  // Import the Scanner class

public class EchoEchoEcho{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        String str = input.nextLine();  // Read user input
        str = str + " ";
        System.out.println(str + str + str);
        
    }
}
