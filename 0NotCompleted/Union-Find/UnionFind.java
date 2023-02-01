public class UnionFind{

    private int[] id;
    private int[] size;
    private int count;

    public UnionFind(int n) {
        id = new int[n];
        size = new int[n];
        count = n;
        for(int i = 0; i<n;i++){
            id[i]=i;
            size[i]=1;
        }
    }

    public int find(int parent){
        int searchNumber = parent;
        while(parent != id[parent]){
            parent = id[parent];
        }
        compress(searchNumber, parent);
        return parent;
    }

    private void compress(int parent, int root) {
        while(parent != id[parent]){
            id[parent] = root;
            parent = id[parent];
        }
    }

    public boolean query(int s, int t){
        return find(s) == find(t);
    }

    public void union(int s, int t) {
        int rootS = find(s);
        int rootT = find(t);

        if(rootS != rootT){
            count--;
            if(size[rootS]<size[rootT]){
                id[rootS] = rootT; 
                size[rootT] += size[rootS];}
            else{
                id[rootT] = rootS; 
                size[rootS] += size[rootT];}
        } 
    }

    public int getCount() {
        return count;
    }

}