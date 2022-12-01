

import java.util.Arrays;
import java.util.Scanner;


public class Patuljci{

    private static int[] drawfsHome;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        drawfsHome = new int[9];
        for(int i = 0; i<9;i++){
            drawfsHome[i] = sc.nextInt(); 
        }
        sc.close();
        for(int i = 0; i< drawfsHome.length; i++){
            for(int j = 1; j< drawfsHome.length-1; j++){
                int[] lineidx = {0,1,2,3,4,5,6,7,8};
                int[] lineArr = new int[9];
                for (int k : lineidx) {
                    if(k!=i && k!= j%drawfsHome.length){
                        lineArr[k]= drawfsHome[k];
                    }
                }
                sum100(lineArr);
            }
        }
    }

    private static void sum100(int[] arr) {
            //int[] arr = drawfLine.stream().mapToInt(i -> i).toArray();
            int sum = Arrays.stream(arr).sum();
            if(sum == 100){
                for (int drawf : arr) {
                    if(drawf!=0){
                        System.out.println(drawf);
                    }
                }
                System.exit(0);
            }   
        }
}