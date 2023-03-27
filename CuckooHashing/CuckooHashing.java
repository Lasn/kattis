import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CuckooHashing{

    private Node[] hashTable;
    private int n;
    private static boolean successful;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for(int i = 0; i< t; i++){
            successful = true;
            String[] firstLine = bf.readLine().split(" ");
            int m = Integer.parseInt(firstLine[0]);
            int n = Integer.parseInt(firstLine[1]);
            CuckooHashing ch = new CuckooHashing(n);
            for(int j = 0; j<m; j++){
                String[] line = bf.readLine().split(" ");
                Node node = new Node(Integer.parseInt(line[0]), Integer.parseInt(line[1]), String.valueOf(j));
                if(successful){
                    ch.insert(node);
                }
            }
            if(successful){
                System.out.println("successful hashing");
            } else {
                System.out.println("rehash necessary");
            }
        }
    }


    public CuckooHashing(int n) {
        this.n = n;
        hashTable = new Node[n];
    }

    public void insert(Node node) {

        if(hashTable[node.getHash1()] == null){
            node.setIndex(node.getHash1());
            hashTable[node.getHash1()] = node;}
        else if(hashTable[node.getHash2()] == null){
            node.setIndex(node.getHash2());
            hashTable[node.getHash2()] = node;
        } else {
            Node rNode = hashTable[node.getHash1()];
            node.setIndex(node.getHash1());
            hashTable[node.getHash1()] = node;
            move(rNode, 0);
        }
  
    }

    private boolean move(Node node, int count){
        if(count > n-1){successful = false; return false;}
        int index = node.getIndex();
        
        if(index == node.getHash2()){

            if(hashTable[node.getHash1()] == null){
                node.setIndex(node.getHash1());
                hashTable[node.getHash1()] = node;
            } else {
                Node rNode = hashTable[node.getHash1()];
                node.setIndex(node.getHash1());
                hashTable[node.getHash1()] = node;
                move(rNode, ++count);}

        } else {

            if(hashTable[node.getHash2()] == null){
                node.setIndex(node.getHash2());
                hashTable[node.getHash2()] = node;
            } else {
                Node rNode = hashTable[node.getHash2()];
                node.setIndex(node.getHash2());
                hashTable[node.getHash2()] = node;
                move(rNode, ++count);
            }
        }
        return true;
      
        }

}