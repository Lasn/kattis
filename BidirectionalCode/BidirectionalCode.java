import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BidirectionalCode {

    private static List<String> pals;
    private static Set<Integer> pals3;
    
    public static void main(String[] args) {
        pals = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String theSum = sc.nextLine();
        sc.close();
        Long rest = Long.valueOf(theSum);
        if(isPal(String.valueOf(rest))){
            printing(String.valueOf(rest));
        }
        for(int i = 0;i<8;i++){
            String pal = newPal(String.valueOf(rest));
            pals.add(pal);
            rest = Long.valueOf(rest)-Long.valueOf(pal);
            //System.out.println(rest);
            if(isPal(String.valueOf(rest))){
                printing(String.valueOf(rest));
            }
            if(rest <= 999){
                //System.out.println(rest);
                break;
            }
        }
        findAllPal3();
        for (Integer int1 : pals3) {
            for (Integer int2 : pals3)  {
                if(int1 +int2 == rest){
                    if(isPal(String.valueOf(int1 +int2))){
                        printing(String.valueOf(int1 +int2));
                    }
                    pals.add(String.valueOf(int2));
                    printing(String.valueOf(int1));
                }
            }
        }
    }

    private static void findAllPal3(){
        pals3 = new TreeSet<>();
        String pal = "";
        for(int i = 1;i<10;i++){
            pal = "";
            pal += i;
            pals3.add(Integer.valueOf(pal));
            pal = "";
            pal += i;
            pal += i;
            pals3.add(Integer.valueOf(pal));
            for(int j = 0; j<10;j++){
                pal = "";
                pal += i;
                pal += j;
                pal += i;
                pals3.add(Integer.valueOf(pal));
            }
        }
        
    } 

    private static void printing(String rest) {
        pals.add(rest);
        System.out.println(pals.size());
        for (String string : pals) {
            System.out.println(string);
        }
        System.exit(0);
        
    }

    public static boolean isPal(String num){
        if(num.length() == 1){
            return true;
        }
        String[] arr = num.split("");
        boolean ispal= false;
        int length = arr.length/2;
        for(int i =0; i<length;i++){
            if(arr[i].equals(arr[arr.length-1-i])){
                ispal= true;
            } else {
                return false;
            }
        }
        return ispal;
    }

    public static String newPal(String rest){
        String newPal = "";
        String[] arr = rest.split("");
        int length = arr.length;

        if(arr[0].equals("1")){
            length -= 1;
            for(int i = 0; i<length; i++){
                newPal += "9";
            }
            return newPal;
        }
        if(!(arr[(length/2)-1].equals("0"))){
            arr[(length/2)-1] = String.valueOf(Integer.valueOf(arr[(length/2)-1]) - 1);
            for(int i =0; i<(length/2);i++) {
                newPal += arr[i];
            }
           } else {
            newPal += String.valueOf(Integer.valueOf(arr[0]) - 1);
            for(int i =1; i<(length/2);i++) {
                newPal += "9";
            }
           }

        if(length%2 !=0){
            newPal += arr[(length/2)];
            StringBuilder sb = new StringBuilder(newPal.substring(0,newPal.length()-1));
            newPal += sb.reverse();
        } else {
            StringBuilder sb = new StringBuilder(newPal);
            newPal += sb.reverse();
        }

        return newPal;
    }
}
