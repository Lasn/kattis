
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class FillingCrates{

    private static Map<Integer,String> crateSize;


    public FillingCrates(int crates) {
        crateSize =  createMap(crates/2);
    }

    public String crates(int amount) {
        if(crateSize.containsKey(amount)){
            return crateSize.get(amount);
        }
   
        for(Iterator<Integer> it = crateSize.keySet().iterator(); it.hasNext();){
            int i = it.next();
            for(Iterator<Integer> it2 = crateSize.keySet().iterator(); it2.hasNext();){
                int j = it2.next();
                int size = i+j;
                if(amount == size){
                    String print = crateSize.get(j)+ " "+ crateSize.get(i);
                    return print;
                }
            }
        }
      
        for(Iterator<Integer> it = crateSize.keySet().iterator(); it.hasNext();){
            int i = it.next();
            for(Iterator<Integer> it2 = crateSize.keySet().iterator(); it2.hasNext();){
                int j = it2.next();
                for(Iterator<Integer> it3 = crateSize.keySet().iterator(); it3.hasNext();){
                    int g = it3.next();
                    int size = i+j+g;
                    if(amount == size){
                        String print = crateSize.get(j)+ " "+ crateSize.get(i) + " "+ crateSize.get(g);
                        return print;
                    }
                }
            }
        }

        return "impossible";
    }


    private TreeMap<Integer,String> createMap(int size) {
        TreeMap<Integer,String> crateSize = new TreeMap<>();
        for(int i = 2; i<=size;i++){
            for(int j = 2; j<=size; j++){
                crateSize.put(i*j, i+ "x"+ j);
            }
        }
        return crateSize;
    }

}