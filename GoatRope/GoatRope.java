
import java.util.Scanner;

public class GoatRope{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int px = sc.nextInt();
        int py = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        sc.close();
        boolean left = false;
        boolean right = false;
        boolean bottom = false;
        boolean top = false;
        int leftOrRight = 0;
        int topOrButtom = 0;

        if(px<x1){
            left = true;
            leftOrRight = x1-px;
        } else if(px>x2){
            right = true;
            leftOrRight = px-x2;
        } if(py<y1){
            bottom = true;
            topOrButtom = y1-py;
        } else if(py>y2){
            top = true;
            topOrButtom = py-y2;
        }
        
        if(left && top || left && bottom || right && top || right && bottom){
            System.out.println(
            Math.sqrt(Math.pow(leftOrRight, 2)+Math.pow(topOrButtom, 2)));
        }
        else if(left){
            System.out.println(x1-px);
        } else if(right){
            System.out.println(px-x2);
        } else if(top){
            System.out.println(py-y2);
        } else if(bottom){
            System.out.println(y1-py);
        }


    }
}