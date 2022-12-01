import java.util.Scanner;

public class BabyBites{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        int count = 0;
        boolean sense = true;
        while(sc.hasNext()){
            String str = sc.next();
            count += 1;
            if(false == (str.equals("mumble")) && count != Integer.valueOf(str)){sense = false;}
        }

        sc.close();
        if(sense){
            System.out.println("makes sense");
        } else {
            System.out.println("something is fishy");
        }
        
        
    }
}