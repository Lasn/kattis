import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = "";
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<2;i++){
            input += sc.nextLine() + "\n";
        }
        sc.close();
        EmagEhtHtiwEmPleh ep = new EmagEhtHtiwEmPleh();
        ep.importPositions(input);
        ep.printBoard();
        
    }
}
