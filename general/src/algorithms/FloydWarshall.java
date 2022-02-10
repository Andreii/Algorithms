package algorithms;

import java.util.*;
import java.io.File;

public class FloydWarshall {
    static class Edge {
        int u,v;
        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("general/resources/g1.txt"));

        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        Map<Edge, Integer> edgeMap = new HashMap<>();

        while(scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            int head = Integer.parseInt(line[0]);
            int tail = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);

            edgeMap.put(new Edge(head,tail), cost);
        }

        int[][][] A =  new int[n+1][n][n];

        for(int u = 1; u < n; u ++) {
            for(int w = 1; w < n; w++) {
                if(u == w) {
                    A[0][u][w] = 0;
                } else {
                    A[0][u][w] = edgeMap.getOrDefault(new Edge(u, w), Integer.MAX_VALUE);
                }
            }
        }

        for(int k = 1; k < n; k++) {
            for(int u = 1; u < n; u++) {
                for(int w = 1; w < n; w++) {
                    A[k][u][w] = Math.min(A[k-1][u][w], A[k-1][u][k] + A[k-1][k][w]);
                }
            }
        }

        for(int u = 1; u < n; u++) {
            if(A[n][u][u] < 0) {
                System.out.println("This graph has a negative cycle!");
                return;
            }
        }

        System.out.println("Solution is: " + A[n][n-1][n-1]);
    }
}
