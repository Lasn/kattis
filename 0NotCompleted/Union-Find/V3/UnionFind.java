public class UnionFind{

    private int[] id;
    private int count;

    public UnionFind(int n) {
        id = new int[n];
        count = n;
        for(int i = 0; i<n;i++){
            id[i]=i;
        }
    }

    private int find(int number){
        int parent = id[number];
        if(parent != number){find(parent);}
        return parent == number ? number : parent;
    }

    public void query(int s, int t) {
        int rootS = find(s);
        int rootT = find(t);

        if(rootS == rootT){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public void union(int s, int t) {
        int rootS = find(s);
        int rootT = find(t);

        if(rootS != rootT){
            id[rootS] = rootT;
            id[s] = rootT;
            count--;
        }
        
    }

    public int getCount() {
        return count;
    }

}