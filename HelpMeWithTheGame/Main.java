import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = "";
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            input += sc.nextLine() + "\n";
        }
        sc.close();
        HelpMeWithTheGame hg = new HelpMeWithTheGame();
        hg.importMap(input);
        hg.printPieces();
    }
}
