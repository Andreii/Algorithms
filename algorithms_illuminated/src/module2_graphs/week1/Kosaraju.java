package module2_graphs.week1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The file contains the edges of a directed graph. Vertices are labeled as positive integers from 1 to 875714. Every
 * row indicates an edge, the vertex label in first column is the tail and the vertex label in second column is the
 * head (recall the graph is directed, and the edges are directed from the first column vertex to the second column
 * vertex). So for example, the 11^{th}11
 * th
 *   row looks liks : "2 47646". This just means that the vertex with label 2 has an outgoing edge to the vertex with
 *   label 47646
 *
 * Your task is to code up the algorithm from the video lectures for computing strongly connected components (SCCs),
 * and to run this algorithm on the given graph.
 *
 * Output Format: You should output the sizes of the 5 largest SCCs in the given graph, in decreasing order of sizes,
 * separated by commas (avoid any spaces). So if your algorithm computes the sizes of the five largest SCCs to be 500,
 * 400, 300, 200 and 100, then your answer should be "500,400,300,200,100" (without the quotes). If your algorithm finds
 * less than 5 SCCs, then write 0 for the remaining terms. Thus, if your algorithm computes only 3 SCCs whose sizes are
 * 400, 300, and 100, then your answer should be "400,300,100,0,0" (without the quotes).  (Note also that your answer
 * should not have any spaces in it.)
 *
 * WARNING: This is the most challenging programming assignment of the course. Because of the size of the graph you may
 * have to manage memory carefully. The best way to do this depends on your programming language and environment, and
 * we strongly suggest that you exchange tips for doing this on the discussion forums.
 */
public class Kosaraju {
    private static int numSCC = 0;
    private static final int LIST_SIZE = 12;
    private static int currentLabel = LIST_SIZE;
    private static Map<Integer, Integer> scc = new HashMap<>(LIST_SIZE);
    private static Map<Integer, Integer> scc_list = new HashMap<>(LIST_SIZE);
    private static List<Integer> topology = new ArrayList<>(LIST_SIZE);


    // SCC_test_1 -> 3,3,3,0,0
    // SCC_test_2 -> 3,3,2,0,0
    // SCC_test_3 -> 3,3,1,1,0
    // SCC_test_4 -> 7,1,0,0,0
    // SCC_test_5 -> 6,3,2,1,0

    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, List<Integer>> adjList = new HashMap<>(LIST_SIZE);
        Map<Integer, List<Integer>> adjListReversed = new HashMap<>(LIST_SIZE);

        Scanner in = new Scanner(new File("algorithms_illuminated/resources/SCC_test_5.txt"));

        for(int i = 0; i <= LIST_SIZE; i++) {
            topology.add(-1);
        }

        while(in.hasNext()) {
            int v = in.nextInt();
            int w = in.nextInt();
            List<Integer> wVertexes = adjList.containsKey(v) ? adjList.get(v) : new ArrayList<>();
            List<Integer> vVertexes = adjListReversed.containsKey(w) ? adjListReversed.get(w) : new ArrayList<>();
            wVertexes.add(w);
            vVertexes.add(v);
            adjList.put(v, wVertexes);
            adjListReversed.put(w, vVertexes);
        }

        kosaraju(adjList, adjListReversed);

        List<Integer> sccCount = scc.values().stream().sorted().collect(Collectors.toList());
        Collections.reverse(sccCount);

        System.out.println(sccCount);
//        System.out.println(scc);
//        System.out.println(scc_list);

//        topology = topology.stream().sorted().distinct().collect(Collectors.toList());
//        Collections.reverse(topology);
//
//        System.out.println(topology.toString());
    }

    public static void kosaraju(Map<Integer, List<Integer>> adjList, Map<Integer, List<Integer>> adjListReversed) {
        Set<Integer> visited = new HashSet<>(LIST_SIZE);
        Set<Integer> visitedReversed = new HashSet<>(LIST_SIZE);

        TopoSort(adjListReversed, visitedReversed);

        for(int i = 1; i < topology.size(); i++) {
            int v = topology.get(i);
            if (! /*NOT*/ visited.contains(v)) {
                numSCC++;
                DFS_SCC(adjList, v, visited);
            }
        }
    }

    private static void DFS_SCC(Map<Integer, List<Integer>> adjList, int s, Set<Integer> visited) {
        visited.add(s);
        scc_list.put(s, numSCC);
        int count = scc.getOrDefault(numSCC, 0);
        scc.put(numSCC, ++count);

        if(! /*NOT*/ adjList.containsKey(s)) return;

        for(Integer v : adjList.get(s)) {
            //guard
            if(visited.contains(v)) continue;

            DFS_SCC(adjList, v, visited);
        }
     }

    private static void TopoSort(Map<Integer, List<Integer>> adjList, Set<Integer> visitedReversed) {
        for(int v = 1; v <= LIST_SIZE; v++) {
            // guard
            if(visitedReversed.contains(v)) continue;

            DFS_Topo(adjList, v, visitedReversed);
        }
    }

    private static void DFS_Topo(Map<Integer, List<Integer>> adjList, int s, Set<Integer> visitedReversed) {
        visitedReversed.add(s);

        if(adjList.containsKey(s)) {
            for(Integer v : adjList.get(s)) {
                // guard
                if(visitedReversed.contains(v)) continue;

                DFS_Topo(adjList, v, visitedReversed);
            }
        }

        topology.set(currentLabel, s);
        currentLabel--;
    }
}
