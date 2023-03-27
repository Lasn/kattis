import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class ThroughTheGrapevine{


    private Map<Integer,Person> people;
    private Set<Person> heard;


    public ThroughTheGrapevine( Map<Integer,Person> people){
        this.people = people;
    }


     public int heardAfter(int days, int startFrom) {
        heard = new HashSet<>();
        Person first = people.get(startFrom);
        first.increaceVisit();
        Deque<Person> queue1 = new ArrayDeque<>();
        queue1.addLast(first);
        for(int i = 0;i<days; i++){
            Deque<Person> queue = queue1;
            queue1 = new ArrayDeque<>();
            while(!queue.isEmpty()){
                Person p = queue.pollFirst();
                for (Person p2 : p.getConnections()) {
                    heard.add(p2);
                    p2.increaceVisit();
                    if(p2.getSkepticism() == p2.getVisit()){
                        queue1.add(p2);
                    }
                }
            }

        }
        heard.remove(first);
        return heard.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] fLine = bf.readLine().split(" ");
        int n = Integer.parseInt(fLine[0]);
        int m = Integer.parseInt(fLine[1]);
        int d = Integer.parseInt(fLine[2]);
        Map<String, Integer> names = new HashMap<>();
        Map<Integer,Person> people = new HashMap<>();
        for(int i = 0; i<n;i++){
            String[] line = bf.readLine().split(" ");
            names.put(line[0], i);
            people.put(i, new Person(line[0], Integer.parseInt(line[1]), i));
        }
        for(int i = 0; i<m;i++){
            String[] line = bf.readLine().split(" ");
            int p1 = names.get(line[0]);
            int p2 = names.get(line[1]);
            people.get(p1).addPerson(people.get(p2));
            people.get(p2).addPerson(people.get(p1));
        }
        int startFrom = names.get(bf.readLine());
        ThroughTheGrapevine ttg = new ThroughTheGrapevine(people);
        System.out.println(ttg.heardAfter(d, startFrom));

    }
}