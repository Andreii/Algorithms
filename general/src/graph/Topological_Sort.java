package graph;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *        2  ->  4
 *      /  \      \
 *     1    3      5
 *      \  /      /
 *       6   -> 7
 *
 *       topo: 1 6 2 3 4 7 5
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

        for(int i = n; i >= 1; i--)
            if(!visited[i])
                topoSort(i, result, visited, adj);

        System.out.println("Topo sort: " + result);
    }

    public static void topoSort(int i, LinkedList<Integer> result, boolean[] visited, List<List<Integer>> adj) {
        visited[i] = true;
        for(Integer u : adj.get(i)) {
            if(!visited[u]) {
                topoSort(u, result, visited, adj);
            }
        }
        result.addFirst(i);
    }
}