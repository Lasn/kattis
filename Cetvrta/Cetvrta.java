import java.util.Scanner;

public class Cetvrta{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] points = {{sc.nextInt(),sc.nextInt()},{sc.nextInt(),sc.nextInt()},{sc.nextInt(),sc.nextInt()}};
        sc.close();
        int missingX = 0;
        int missingY = 0;
        

        if(points[0][0] == points[1][0]){
            missingX = points[2][0];
        } else if (points[0][0] == points[2][0]) {
            missingX = points[1][0];
        } else{
            missingX = points[0][0];
        }
        if(points[0][1] == points[1][1]){
            missingY = points[2][1];
        } else if (points[0][1] == points[2][1]) {
            missingY = points[1][1];
        } else{
            missingY = points[0][1];
        }
        
        System.out.println(missingX + " " + missingY);   
    }
}