import java.util.Scanner;

public class Tri {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);  // Create a Scanner object
      String str = input.nextLine();  // Read user input
      String[] arrOfStr = str.split(" ");
      int a = Integer.valueOf(arrOfStr[0]);
      int b = Integer.valueOf(arrOfStr[1]);
      int c = Integer.valueOf(arrOfStr[2]);
      input.close();
      if(a+b == c){
        System.out.println(a + "+" + b + "=" + c);
      } else if(a-b == c) {
        System.out.println(a + "-" + b + "=" + c);
      } else if(a*b == c) { 
        System.out.println(a + "*" + b + "=" + c);
      } else if(a/b == c) { 
        System.out.println(a + "/" + b + "=" + c);
      } else if(b+c == a) {
        System.out.println(a + "=" + b + "+" + c);
      } else if(b-c == a) {
        System.out.println(a + "=" + b + "-" + c);
      } else if(b*c == a) {
        System.out.println(a + "=" + b + "*" + c);
      } else if(b/c == a) {
        System.out.println(a + "=" + b + "/" + c);
      } 
    }
}
