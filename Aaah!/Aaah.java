import java.util.Scanner;
import java.util.ArrayList; 

public class Aaah{
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<String>();
        Scanner input = new Scanner(System.in);

        while(input.hasNextLine()){
            lines.add(input.nextLine());
        }
        // app calculation
        int lastWordLength = 1001;
        for (String line : lines) {
            if(lastWordLength == 1001){
                lastWordLength = line.length();
            } else if(lastWordLength < line.length()){
                System.out.println("no");
            } else if(lastWordLength >= line.length()){
                System.out.println("go");
            }
        }
    }
}
