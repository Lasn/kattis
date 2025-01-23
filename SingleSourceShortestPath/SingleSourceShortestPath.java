import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class SingleSourceShortestPath{

    private Map<Integer,Set<Edge>> graph;
    private int[] distTo;
    private int[] marked;

    public SingleSourceShortestPath(Map<Integer,Set<Edge>> graph){
        this.graph = graph;
    }


    public void calShortestPath(int start) {
        distTo = new int[graph.size()];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        marked = new int[graph.size()];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x1,x2) -> x1[1] - x2[1]);
        int[] s ={start,0};
        pq.add(s); 
        distTo[start] = 0;
        while(!pq.isEmpty()){
            int[] v = pq.poll();
            marked[v[0]] = 1;
            for (Edge e : graph.get(v[0])) {
                int other = e.getW();
                int newDistTo = e.getWeight() + v[1];
                if(newDistTo < distTo[other]){
                    distTo[other] = newDistTo;
                    int[] nd = {other, newDistTo};
                    if(marked[other] == 0){pq.add(nd);}
                    
                }
            }

        }
    }

    public int findShortestPath(int end) {
        int dist = distTo[end];
        if(dist == Integer.MAX_VALUE){return -1;}
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean run = true;
        while(run){
            Map<Integer,Set<Edge>> dgraph = new HashMap<>();
            String fLine = bf.readLine();
            if(fLine.equals("0 0 0 0")){break;}
            String[] line = fLine.split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int q = Integer.parseInt(line[2]);
            int s = Integer.parseInt(line[3]);
            for(int i = 0; i< n;i++){
                dgraph.put(i, new HashSet<>());
            }
            for(int i = 0; i< m;i++){
                String[] input = bf.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);
                int w = Integer.parseInt(input[2]);
                Set<Edge> edges  = dgraph.get(u);
                edges.add(new Edge(u, v, w));
                dgraph.put(u, edges);
            }
            SingleSourceShortestPath sssp = new SingleSourceShortestPath(dgraph);
            sssp.calShortestPath(s);
            for(int i = 0; i<q;i++){
                int e = Integer.parseInt(bf.readLine());
                int dist = sssp.findShortestPath(e);
                System.out.println(dist == -1 ? "Impossible" : dist);
              
            }
            System.out.println();
        }

    }

}