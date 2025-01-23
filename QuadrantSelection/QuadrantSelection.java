import java.util.Scanner;

public class QuadrantSelection {
    public static void main(String[] args) {
        int[] arrOfInt = new int[2];
        Scanner input = new Scanner(System.in);
        for(int i = 0; i<2; i++){
          arrOfInt[i] = Integer.valueOf(input.nextLine());
        }
        input.close();

        if(arrOfInt[0] > 0 && arrOfInt[1] > 0){
          System.out.println("1");
        } else if(arrOfInt[0] < 0 && arrOfInt[1] > 0){
          System.out.println("2");
        } else if(arrOfInt[0] < 0 && arrOfInt[1] < 0){
          System.out.println("3");
        } else if(arrOfInt[0] > 0 && arrOfInt[1] < 0){
          System.out.println("4");
        }
    }
}
