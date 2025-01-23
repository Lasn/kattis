import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.Iterator;

class precariousstacks {

    private static long highstack;
    private static TreeMap<Long, long[]> map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine().trim());
        highstack = 0;
        map = new TreeMap<>();
        for (long i = 0; i < n; i++) {
            String[] line = bf.readLine().split(" ");
            long x = Long.parseLong(line[0]);
            long s = Long.parseLong(line[1]);
            Long floor = map.floorKey(x);
            Long ceil = map.ceilingKey(x + s);
            if (floor == null && ceil == null) {
                long[] arr = new long[] { x, x + s, s };
                map.put(x, arr);
                if (s > highstack) {
                    highstack = s;
                }

            } else {
                floor = floor == null ? x : floor;
                ceil = ceil == null ? x + s : ceil;
                NavigableMap<Long, long[]> submap = map.subMap(floor, true, ceil, true);
                long highest = 0;
                for (Iterator<Long> it = submap.keySet().iterator(); it.hasNext();) {
                    long[] node = submap.get(it.next());
                    if (x + s > node[0] && x < node[1] || x < node[1] && x + s > node[0]) {
                        if (node[2] > highest)
                            highest = node[2];
                        if (node[0] >= x && node[1] <= x + s)
                            it.remove();
                        else if (node[0] < x && node[1] > x + s) {
                            long[] node1 = new long[] { node[0], x, node[2] };
                            long[] node2 = new long[] { x + s, node[1], node[2] };
                            it.remove();
                            map.put(node1[0], node1);
                            map.put(node2[0], node2);
                        } else if (node[0] < x) {
                            node[1] = x;
                        } else if (node[1] < x + s) {
                            map.put(x + s, new long[] { x + s, node[1], node[2] });
                            it.remove();
                        }
                    }

                }
                highstack = s + highest > highstack ? s + highest : highstack;
                long[] arr = new long[] { x, x + s, highest + s };
                map.put(x, arr);

            }
            System.out.println(highstack);
        }

    }

}
