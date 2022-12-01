import java.util.Scanner;

public class Howl{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        String str = input.nextLine();  // Read user input
        input.close();
        String howl=str;
        for (int i =0; i<2; i++) {
            String lastIdx = howl.substring(howl.length()-1, howl.length());
            if(lastIdx.equals("W")){
                howl += "H";
            } else if(lastIdx.equals("O")){
                howl += "W";
            } else if(lastIdx.equals("A")){
                howl += "A";
            } else if(lastIdx.equals("H")){
                howl += "O";
            }
        }
        System.out.println(howl); 
     }
}
    