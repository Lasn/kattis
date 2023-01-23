import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UnionFind{

    private static List<Element> list;

    public static void main(String[] args) throws IOException {
        list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        Integer n = Integer.parseInt(firstLine[0]);
        Integer q = Integer.parseInt(firstLine[1]);

        for(int i = 0; i<n; i++){
            list.add(new Element(String.valueOf(i), i));
        }
    
        for(int i = 0; i<q; i++){
            String[] line = br.readLine().split(" ");
            Integer a = Integer.parseInt(line[1]);
            Integer b = Integer.parseInt(line[2]);

            switch(line[0]){
                case "?" : query(a, b);  break;
                case "=" : union(a, b); break;
            }

        }

    }

    private static Integer find(Integer number){
        Integer parent = list.get(number).getParent();
        while(parent != number){
            number = parent;
            parent = list.get(number).getParent();
        }
        return parent;
    }

    private static void query(Integer s, Integer t) {
        Integer rootS = find(s);
        Integer rootT = find(t);

        if(rootS.equals(rootT)){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static void union(Integer s, Integer t) {
        Integer rootS = find(s);
        Integer rootT = find(t);

        if(!rootS.equals(rootT)){
            list.get(rootT).setParent(rootS);
         }
    }

}