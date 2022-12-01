import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class BaconEggsandSpam{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            Map<String,Set<String>> order = new TreeMap<>();
            int n = Integer.parseInt(sc.nextLine());
            if(n == 0){
                break;
            }
            for(int i = 0; i<n;i++){
                String[] line = sc.nextLine().split(" ");
                String name = line[0];
                for(int o = 1; o<line.length; o++){
                    String item = line[o];
                    if(!order.containsKey(item)){
                        Set<String> names = new TreeSet<>();
                        names.add(name);
                        order.put(item, names);
                    } else {
                        order.get(item).add(name);
                    }
                    
                }
            }
            for(Iterator<String> it = order.keySet().iterator(); it.hasNext();){
                String key = it.next();
                String p = key;
                for (String string : order.get(key)) {
                    p += " " + string;
                }
                System.out.println(p);
            }
            System.out.println("");
        }
        sc.close();
        

    }
}