import java.util.Scanner;  // Import the Scanner class

public class IsItHalloween {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);  // Create a Scanner object
    String str = input.nextLine();  // Read user input
    //String strStrip = str.strip();
    //String strUp = strStrip.toUpperCase();
    switch(str) {
      case "OCT 31":
        System.out.println("yup");
        break;
      case "DEC 25":
        System.out.println("yup");
        break;
      default:
        System.out.println("nope");
        break;
    }
  }
}