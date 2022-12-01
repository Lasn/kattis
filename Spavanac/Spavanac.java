import java.util.Scanner;  // Import the Scanner class


public class Spavanac {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);  // Create a Scanner object
    String str = input.nextLine();  // Read user input
    String[] arrOfStr = str.split(" ");
    int[] arrOfInt = new int[arrOfStr.length];
    for(int i = 0; i < arrOfStr.length; i++){
      arrOfInt[i] = Integer.valueOf(arrOfStr[i]);
    }
    if(arrOfInt[1]-45 < 0) {
      arrOfInt[1] = ((arrOfInt[1] + 60) - 45);
      if(arrOfInt[0] != 0){
        arrOfInt[0] = arrOfInt[0]-1;
      } else {
        arrOfInt[0] = 23;
      }
      
    } else {
      arrOfInt[1] = arrOfInt[1] - 45;
    }
    System.out.println(arrOfInt[0] + " " + arrOfInt[1]);
  }
}