public class Node {
    
    private int hash1;
    private int hash2;
    private String name;
    private int index;

    public Node(int hash1, int hash2, String name) {
        this.hash1 = hash1;
        this.hash2 = hash2;
        this.name = name;
    }

    public int getHash1() {
        return hash1;
    }

    public void setHash1(int hash1) {
        this.hash1 = hash1;
    }

    public int getHash2() {
        return hash2;
    }

    public void setHash2(int hash2) {
        this.hash2 = hash2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    
}
