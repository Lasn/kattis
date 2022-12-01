

import java.util.HashSet;
import java.util.Set;

public class CD{
    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        while(true){
            long cds = sc.getLong() + sc.getLong();
            if(cds == 0){
                break;
            }
            Set<Long> uniqueCD = new HashSet<>();
            for(int i = 0; i<cds; i++){
                uniqueCD.add(sc.getLong());
            }
            System.out.println(cds-uniqueCD.size());
        }
        
        sc.close();
    }
}