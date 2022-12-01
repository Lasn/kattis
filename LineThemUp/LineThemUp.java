import java.util.Scanner;

public class LineThemUp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx = sc.nextInt();
        boolean increase = false;
        boolean decrease = false;
        String lastName = sc.next();
        for(int i = 0; i< idx-1; i++){
            String nextName = sc.next();
            if(lastName.compareTo(nextName) < 1){
                increase = true;
            } else {
                decrease = true;
            }
            lastName = nextName;
        }
        sc.close();
        if(increase==decrease) {System.out.println("NEITHER");}
        else if(increase){
            System.out.println("INCREASING");
        } else if(decrease){
            System.out.println("DECREASING");
        } 
    }
}