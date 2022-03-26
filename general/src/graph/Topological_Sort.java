package graph;

import java.io.File;
import java.util.*;

/**
 *        2  ->  4
 *       .\       \
 *      /  .       .
 *     1    3      5
 *     \   .      .
 *      . /      /
 *       6   -> 7
 *
 *       (topo.txt): 1 6 2 3 4 7 5
 */
public class Topological_Sort {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("general/resources/topo.txt"));

        int n =  scanner.nextInt();
        List<List<Integer>> adj = new ArrayList<>(n);
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        while(scanner.hasNext()) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            adj.get(from).add(to);
        }

        LinkedList<Integer> result = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        for(int i = 1; i <= n; i++)
            if(!visited[i])
                topoSortDFS(i, result, visited, adj);
        System.out.println("Topo DFS sort: " + result);

        LinkedList<Integer> res = new LinkedList<>();
        topoSortKahnBFS(res,adj,n);
        System.out.println("Topo Kahn sort: " + res);
    }

    public static void topoSortDFS(int i, LinkedList<Integer> result, boolean[] visited, List<List<Integer>> adj) {
        visited[i] = true;
        for(Integer u : adj.get(i)) {
            if(!visited[u]) {
                topoSortDFS(u, result, visited, adj);
            }
        }
        result.addFirst(i);
    }

    public static void topoSortKahnBFS(LinkedList<Integer> result, List<List<Integer>> adj, int n) {
        int[] indegree = new int[n+1];

        Arrays.fill(indegree, 0);
        for(int i = 1; i < adj.size(); i++) {
            List<Integer> dests = adj.get(i);
            for(Integer dest : dests) {
                indegree[dest]++;
            }
        }

        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int u = q.poll();

            result.add(u);
            for(Integer node : adj.get(u)) {
                if(--indegree[node] == 0) {
                    q.add(node);
                }
            }
        }
    }
}