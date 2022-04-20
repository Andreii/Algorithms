/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.general.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.LinkedList;
import java.util.HashSet;

class _Shortest_path_from_a_to_b {
    protected static int bfs(List<List<Integer>> graph, int a, int b) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(a);

        int level = 1;
        HashSet<Integer> visited = new HashSet<>();
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                Integer curr = q.pop();
                if(visited.contains(curr)) return level;
                for(Integer neighbour : graph.get(curr)) {
                    if(neighbour == b) return level;
                    q.add(neighbour);
                    visited.add(neighbour);
                }
            }
            level ++;
        }
        return -1;
    }
    public static int shortestPath(List<List<Integer>> graph, int a, int b) {
        if(graph == null) return 0;
        return bfs(graph,a,b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int graphLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < graphLength; i++) {
            String s = scanner.nextLine();
            List<String> l =  s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
            graph.add(l.stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = shortestPath(graph, a, b);
        System.out.println(res);
    }
}