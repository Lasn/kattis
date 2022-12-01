import java.util.Scanner;

public class NineKnights {
    private static String[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] list = new String[5][5];
        boolean boardValid = true;
        int intKnights = 0;
        for(int i = 0; i<5;i++){
            list[i] = sc.nextLine().split("");
        }
        sc.close();
        board = list;
        for(int y = 0; y<5;y++){
            for(int x = 0;x<5;x++){
                if(board[y][x].equals("k")){
                    boolean valid = validPlace(y, x);
                    intKnights += 1;
                    if(!valid){
                        System.out.println("invalid");
                        boardValid = false;
                        System.exit(0);
                    }
                }
            }
        }
        if(boardValid && intKnights == 9){
            System.out.println("valid");
        } else {System.out.println("invalid");}
    }

    public static boolean validPlace(int py, int px){
        //y x koorditat check
        int[][] test = {{-2,-1},{-2,1},{-1,2},{1,2},
                        {2,1},{2,-1},{1,-2},{-1,-2}};
        for(int i = 0; i < 8; i++){
           try{
            int y = test[i][0]+py;
            int x = test[i][1]+px;
            if(board[y][x].equals("k")){
                return false; }
        } catch(ArrayIndexOutOfBoundsException e) {
            
        }
    }
    return true;
    }
}