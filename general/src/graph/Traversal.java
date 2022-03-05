package graph;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Traversal {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("general/resources/graph.txt"));

        int n = Integer.parseInt(sc.nextLine());
        List<List<Integer>> AL = new ArrayList<>(n);

        while(sc.hasNext()) {
            List<Integer> line = Arrays.stream(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Integer origin = line.remove(0);
            AL.add(origin, line);
        }

        printGraph(AL);
        dfs_recursive(0, AL, new HashSet<>(n));
        System.out.println();
        dfs_iterative(AL);
        System.out.println();
        bfs_iterative(AL);
        System.out.println();
        bfs_recursive(AL, new ArrayDeque<>() {{ add(0); }}, new HashSet<>());
    }

    static void printGraph(List<List<Integer>> AL) {
        for(int i = 0; i < AL.size(); i++) {
            System.out.print(i + ": ");
            for(Integer vertex : AL.get(i)) {
                System.out.print(vertex + ",");
            }
            System.out.println();
        }
    }

    static void dfs_recursive(Integer v, List<List<Integer>> AL, Set<Integer> visited) {
        System.out.println("DFS Visiting -> " + v);
        visited.add(v);
        for(Integer w : AL.get(v)) {
            if(!visited.contains(w)) {
                dfs_recursive(w, AL, visited);
            }
        }
    }

    static void dfs_iterative(List<List<Integer>> AL) {
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(0);

        while(!queue.isEmpty()) {
            Integer v = queue.pollLast();
            if(!visited.contains(v)) {
                visited.add(v);
                System.out.println("DFS Visiting -> " + v);
            }
            for(int i = AL.get(v).size()-1 ; i >= 0; i--) {
                Integer w = AL.get(v).get(i);
                if(!visited.contains(w)) {
                    queue.add(w);
                }
            }
        }
    }

    static void bfs_recursive(List<List<Integer>> AL, Queue<Integer> q, Set<Integer> visited) {
        if(q.isEmpty()) return;

        Integer v = q.poll();
        System.out.println("BFS Visiting -> " + v);

        for(Integer w : AL.get(v)) {
            if(!visited.contains(w)) {
                visited.add(w);
                q.add(w);
            }
        }

        bfs_recursive(AL, q, visited);
    }

    static void bfs_iterative(List<List<Integer>> AL) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(0);
        while(!queue.isEmpty()) {
            Integer v = queue.poll();
            System.out.println("BFS Visiting -> " + v);
            for(Integer w : AL.get(v)) {
                if(!visited.contains(w)) {
                    visited.add(w);
                    queue.add(w);
                }
            }
        }
    }
}