import java.util.Scanner;  // Import the Scanner class

public class TakeTwoStones {
  
  private static String[] people = {"Alice", "Bob"};

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);  // Create a Scanner object
    String str = input.nextLine();  // Read user input
    int number = Integer.valueOf(str);
    if(number % 2 == 0){
      System.out.println(people[1]);
    } else {
      System.out.println(people[0]);
    }

  }
}