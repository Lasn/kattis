import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BasicProgramming2{
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] l1 = sc.readLine().split(" ");
        String[] l2 = sc.readLine().split(" ");
        int n = Integer.parseInt(l1[0]);
        int t = Integer.parseInt(l1[1]);
        sc.close();
        switchC(t,l2);
    }

    public static void switchC(int t, String[] a) {
        switch(t){
            case 1 : System.out.println(one(a)); break;

            case 2 : System.out.println(two(a)); break;

            case 3 : System.out.println(three(a)); break;

            case 4 : System.out.println(four(a)); break;

            case 5 : System.out.println(five(a)); break;

        }    
    }

    private static String one(String[] a) {
        Set<Integer> interval = new HashSet<>();
        Arrays.stream(a).map(n -> Integer.parseInt(n)).filter(n -> n < 7778).forEach(n -> interval.add(n));
        for(Iterator<Integer> it = interval.iterator(); it.hasNext();){
            int x = it.next();
            int y = 7777-x;
            if(interval.contains(y)){
                return "Yes";
            }
        }
        return "No";
    }

    private static String two(String[] a) {
        Set<String> setA = new HashSet<>();
        for (String string : a) {
            if(setA.contains(string)){
                return "Contains duplicate";
            }
            setA.add(string);
        }
        return "Unique";
    }

    private static String three(String[] a) {
        Map<String,Integer> aSet = new HashMap<>();
        int n = a.length;
        for (String string : a) {
            if(aSet.containsKey(string)){
                int value = aSet.get(string);
                if((value +1) > n/2){
                    return string;
                }
                aSet.put(string, value+1);
            } else {
                aSet.put(string, 1);
            }
        }
        return "-1";
    }

    private static String four(String[] a) {
        String print = "";
        int size = a.length;
        ArrayList <Integer> intA = new ArrayList<>();
        Arrays.stream(a).map(x -> Integer.parseInt(x)).sorted().forEach(x -> intA.add(x));
        if(size%2==0){
            print += intA.get((size/2)-1) + " " + intA.get(size/2);
        } else {
            print += intA.get(size/2);
        }
        return print;
    }

    private static String five(String[] a) {
        StringBuilder sb = new StringBuilder();
        ArrayList <Integer> rangeList = new ArrayList<>();
        Arrays.stream(a).map(x -> Integer.parseInt(x))
                        .filter(x -> x > 99 && x < 1000)
                        .forEach(x -> rangeList.add(x));
        rangeList.sort(null);
        rangeList.forEach(x -> sb.append(x + " "));
        return sb.toString().stripTrailing();
    }



    
}