import java.util.Scanner;

public class BoundingRobots{

    private static String print = "";
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while(run){
            int []rThinkPlace = {0,0};
            int []rPlace = {0,0};
            String[] line1 = sc.nextLine().split(" ");
            int w = Integer.valueOf(line1[0]);
            int l = Integer.valueOf(line1[1]);
            if(w == 0 && l == 0){
                run = false;
                break;
            }
            int n = Integer.valueOf(sc.nextLine());
            for(int i = 0; i < n; i++){
                String[] line3 = sc.nextLine().split(" ");
                String x = line3[0];
                int y= Integer.valueOf(line3[1]);
                switch(x){
                    case "u":
                    rThinkPlace[0] += y;
                    if(rPlace[0] + y <= l-1) {
                        rPlace[0] += y;
                    } else {
                        rPlace[0] = l-1;
                    }
                    break;
                    case "d":
                    rThinkPlace[0] -= y;
                    if(rPlace[0] - y >= 0) {
                        rPlace[0] -= y;
                    } else {
                        rPlace[0] = 0;
                    }
                    break;
                    case "l":
                    rThinkPlace[1] -= y;
                    if(rPlace[1] - y >= 0) {
                        rPlace[1] -= y;
                    } else {
                        rPlace[1] = 0;
                    }
                    break;
                    case "r":
                    rThinkPlace[1] += y;
                    if(rPlace[1] + y <= w-1) {
                        rPlace[1] += y;
                    } else {
                        rPlace[1] = w-1;
                    }
                    break;
                }
            }
            print += "Robot thinks "+rThinkPlace[1]+" "+rThinkPlace[0] + "\n";
            print += "Actually at "+rPlace[1]+" "+rPlace[0] + "\n\n";
        }
        sc.close();
        System.out.println(print.trim());
    }   
}