package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Kosaraju {
    private static int numSCC = 0;
    private static final int LIST_SIZE = 875_715;
    private static int currentLabel = LIST_SIZE-1;
    private static Map<Integer, Integer> scc = new HashMap<>(LIST_SIZE);
    private static List<Integer> topology = new ArrayList<>(LIST_SIZE);

    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, List<Integer>> adjList = new HashMap<>(LIST_SIZE);
        Map<Integer, List<Integer>> adjListReversed = new HashMap<>(LIST_SIZE);

        Scanner in = new Scanner(new File("/home/act/mds/projects/git/algo/general/src/algorithms/SCC.txt"));

        for(int i = 1; i <= LIST_SIZE; i++) {
            topology.add(-1);
        }

        while(in.hasNext()) {
            String line = in.nextLine();
            int v = Integer.parseInt(line.split("\\s")[0]);
            int w = Integer.parseInt(line.split("\\s")[1]);
            List<Integer> wVertexes = adjList.containsKey(v) ? adjList.get(v) : new ArrayList<>();
            wVertexes.add(w);
            adjList.put(v, wVertexes);
        }

        // compute reverse adjList
        for(int v = 1; v < LIST_SIZE; v++) {
            if(adjList.containsKey(v)) {
                for(int w : adjList.get(v)) {
                    List<Integer> toReplace =  adjListReversed.containsKey(w) ? adjListReversed.get(w) : new ArrayList<>();
                    toReplace.add(v);
                    adjListReversed.put(w, toReplace);
                }
            }
        }

        kosaraju(adjList, adjListReversed);

    }

    public static void kosaraju(Map<Integer, List<Integer>> adjList, Map<Integer, List<Integer>> adjListReversed) {
        Set<Integer> visited = new HashSet<>(875_715);
        Set<Integer> visitedReversed = new HashSet<>(875_715);

        TopoSort(adjListReversed, visitedReversed);

        for(int i = 1; i < topology.size(); i++) {
            int v = topology.get(i);
            if (adjList.containsKey(v) && ! /*NOT*/ visited.contains(v)) {
                numSCC++;
                DFS_SCC(adjList, v, visited);
            }
        }
    }

    private static void DFS_SCC(Map<Integer, List<Integer>> adjList, int s, Set<Integer> visited) {
        visited.add(s);
        int count = scc.getOrDefault(numSCC, 0);
        scc.put(numSCC, ++count);

        if(! /*NOT*/ adjList.containsKey(s)) return;

        for(Integer v : adjList.get(s)) {
            if(! /*NOT*/ visited.contains(v)) {
                DFS_SCC(adjList, v, visited);
            }
        }
     }

    private static void TopoSort(Map<Integer, List<Integer>> adjList, Set<Integer> visitedReversed) {
        for(int v = 1; v < LIST_SIZE; v++) {
            if(adjList.containsKey(v) && !/*NOT*/visitedReversed.contains(v)) {
                DFS_Topo(adjList, v, visitedReversed);
            }
        }
    }

    private static void DFS_Topo(Map<Integer, List<Integer>> adjList, int s, Set<Integer> visitedReversed) {
        visitedReversed.add(s);

        if(! /*NOT*/ adjList.containsKey(s)) return;

        for(Integer v : adjList.get(s)) {
            if(! /*NOT*/ visitedReversed.contains(v)) {
                DFS_Topo(adjList, v, visitedReversed);
            }
        }

        topology.set(currentLabel, s);
        currentLabel--;
    }
}
