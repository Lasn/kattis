import java.util.HashSet;
import java.util.Set;

public class Person {
   
    private String name;
    private int skepticism;
    private int index;
    private Set<Person> connections;
    private int visit;




    public Person(String name, int skepticism, int index) {
        this.name = name;
        this.skepticism = skepticism;
        this.index = index;
        connections = new HashSet<>();

        
    }


    public void addPerson(Person p ) {
        connections.add(p);
    }

    public Set<Person> getConnections() {
        return connections;
    }


    public void increaceVisit() {
        visit++;
    }

    public int getVisit() {
        return visit;
    }


    public String getName() {
        return name;
    }


    public int getSkepticism() {
        return skepticism;
    }


    public void decreseSkepticism() {
    
        this.skepticism--;
    }


    public int getIndex() {
        return index;
    }


}
