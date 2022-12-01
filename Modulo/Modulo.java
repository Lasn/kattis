import java.util.Scanner;  // Import the Scanner class
import java.util.HashSet;  // Import the HashMap class

public class Modulo {
  public static void main(String[] args) {
    HashSet<Integer> modoData = new HashSet<Integer>();
    Scanner input = new Scanner(System.in);  // Create a Scanner object
    for(int i=0; i<10; i++){
      String str = input.nextLine(); // Read user input
      int num = Integer.valueOf(str);
      int modo = num % 42;
      modoData.add(modo);
    }
    System.out.println(modoData.size());
}
}