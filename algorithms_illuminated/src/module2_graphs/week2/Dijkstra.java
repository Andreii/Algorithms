package module2_graphs.week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The file contains an adjacency list representation of an undirected weighted graph with 200 vertices labeled
 * 1 to 200.  Each row consists of the node tuples that are adjacent to that particular vertex along with the length of
 * that edge. For example, the 6th row has 6 as the first entry indicating that this row corresponds to the vertex
 * labeled 6. The next entry of this row "141,8200" indicates that there is an edge between vertex 6 and vertex 141
 * that has length 8200.  The rest of the pairs of this row indicate the other vertices adjacent to vertex 6 and the
 * lengths of the corresponding edges.
 *
 * Your task is to run Dijkstra's shortest-path algorithm on this graph, using 1 (the first vertex) as the source
 * vertex, and to compute the shortest-path distances between 1 and every other vertex of the graph. If there is no
 * path between a vertex vv and vertex 1, we'll define the shortest-path distance between 1 and vv to be 1000000.
 *
 * You should report the shortest-path distances to the following ten vertices, in order: 7,37,59,82,99,115,133,165,
 * 188,197.  You should encode the distances as a comma-separated string of integers. So if you find that all ten of
 * these vertices except 115 are at distance 1000 away from vertex 1 and 115 is 2000 distance away, then your answer
 * should be 1000,1000,1000,1000,1000,2000,1000,1000,1000,1000. Remember the order of reporting DOES MATTER, and the
 * string should be in the same order in which the above ten vertices are given. The string should not contain any
 * spaces.  Please type your answer in the space provided.
 *
 * IMPLEMENTATION NOTES: This graph is small enough that the straightforward O(mn)O(mn) time implementation of
 * Dijkstra's algorithm should work fine.  OPTIONAL: For those of you seeking an additional challenge, try implementing
 * the heap-based version.  Note this requires a heap that supports deletions, and you'll probably need to maintain
 * some kind of mapping between vertices and their positions in the heap.
 */
public class Dijkstra {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("algorithms_illuminated/resources/dijkstra.txt"));
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<String,Integer> lenvw = new HashMap<>();

        while(in.hasNext()) {
            String[] touples = in.nextLine().split("\t");

            int v = Integer.parseInt(touples[0]);
            for(int i = 1; i < touples.length; i++) {
                String[] toupleArr = touples[i].split(",");
                int w = Integer.parseInt(toupleArr[0]);
                int vwLen = Integer.parseInt(toupleArr[1]);

                // build adjancent list
                List<Integer> wElements;
                if(adjList.containsKey(v)) {
                    wElements = adjList.get(v);
                    wElements.add(w);
                } else {
                    wElements = new ArrayList<>() {{ add(w); }};
                }
                adjList.put(v, wElements);


                // build length list
                lenvw.put(
                        Arrays.stream(new int[] {v, w})
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining(",")),
                        vwLen
                );
            }
        }

//        for(Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
//            System.out.println(entry.getKey());
//        }

        for(Map.Entry<String, Integer> entry : lenvw.entrySet()) {
            System.out.printf("%s - %d \n", entry.getKey(), entry.getValue());
        }

        Map<Integer, Integer> shortestPath = dijkstra(adjList, lenvw, 1);

        for(Map.Entry<Integer, Integer> entry : shortestPath.entrySet()) {
            System.out.printf("%d - %d \n", entry.getKey(), entry.getValue());
        }

        int[] wantedLengths = new int[] {7,37,59,82,99,115,133,165,188,197};
        System.out.printf("Length array: %s", Arrays.stream(wantedLengths)
                .map(shortestPath::get)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));

    }

    private static Map<Integer,Integer> dijkstra(Map<Integer, List<Integer>> adjList, Map<String, Integer> lenvw, int start) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer,Integer> len = new HashMap<>();
        visited.add(start);
        len.put(start, 0);

        dfs_dijkstra(adjList,lenvw,len,visited);

        return len;
    }

    private static void dfs_dijkstra(
            Map<Integer, List<Integer>> adjList,
            Map<String, Integer> lenvw,
            Map<Integer,Integer> len,
            Set<Integer> visited
    ) {
        int[] vw = getShortestEdge(adjList, lenvw, len, visited);
        int v = vw[0];
        int w = vw[1];

        if(w != -1) {
            visited.add(w);
            len.put(w, len.get(v) + getVWLength(v, w, lenvw));
            dfs_dijkstra(adjList, lenvw, len, visited);
        }
    }

    private static int getVWLength(int v, int w, Map<String, Integer> lenvw) {
        return lenvw.getOrDefault(
                Arrays.stream(new int[] {v,w})
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(",")), Integer.MAX_VALUE
        );
    }

    private static int[] getShortestEdge (
            Map<Integer, List<Integer>> adjList,
            Map<String, Integer> lenvw,
            Map<Integer, Integer> len,
            Set<Integer> visited
    ) {
        int[] minvw = new int[] {-1,-1};
        int min = Integer.MAX_VALUE;

        for(Integer v : visited) {
            for(Integer w : adjList.get(v)) {
                if(!/*NOT*/visited.contains(w)) {
                    int vwstart = len.get(v) + getVWLength(v,w,lenvw);
                    if( vwstart < min) {
                        min = vwstart;
                        minvw[0] = v;
                        minvw[1] = w;
                    }
                }
            }
        }

        return minvw;
    }
}

