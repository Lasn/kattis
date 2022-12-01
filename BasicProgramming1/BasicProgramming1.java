import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class BasicProgramming1{
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] l1 = sc.readLine().split(" ");
        String[] l2 = sc.readLine().split(" ");
        int t = Integer.parseInt(l1[1]);
        sc.close();
        switchC(t, l2);
    }

    public static void switchC(int t, String[] a) {
       
        switch(t){
            case 1 : System.out.println(7); break;

            case 2 : Integer a0 = Integer.parseInt(a[0]); Integer a1 = Integer.parseInt(a[1]);
                        if(a0>a1){System.out.println("Bigger");}
                        else if(a0.equals(a1)){System.out.println("Equal");}
                        else {System.out.println("Smaller");} break;

            case 3 : String[] newA = {a[0],a[1],a[2]}; Arrays.sort(newA); System.out.println(newA[1]); break; 

            case 4 : long sum = Arrays.stream(a).map(x -> Long.parseLong(x))
                                                .reduce((long)0, (x1,x2) -> x1 + x2); 
                                                System.out.println((long)sum); break;

            case 5 : long sum2 = Arrays.stream(a).map(x -> Long.parseLong(x))
                                                .filter(x -> x%2==0).reduce((long)0, (x1,x2) -> x1 + x2); 
                                                System.out.println((long)sum2); break;

            case 6 : StringBuilder sb = new StringBuilder(); Arrays.stream(a).map(i -> Character.toString((Integer.parseInt(i)%26)+97))
                                                .forEach(x -> sb.append(x)); System.out.println(sb); break;

            case 7 : System.out.println(seven(a)); break;
        }    
    }

    private static String seven(String[] a) {
        Integer i = 0;
        Integer size = a.length;
        Set<Integer> idx = new HashSet<>();
        while(true){
            i = Integer.valueOf(a[i]);
            if(i.equals(size-1)) {
                return "Done";
            } if(i>size-1){
                return "Out";
            } if(idx.contains(i)){
                return "Cyclic";
            }
            idx.add(i);
        }
    }
}