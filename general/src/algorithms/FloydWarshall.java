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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return u == edge.u && v == edge.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v);
        }
    }

    public static void main(String[] args) throws Exception {
        // can go to around 2gb mem, 2byte x 1000 x 1000 x 1000
        Scanner scanner = new Scanner(new File("general/resources/all-paths-shortest-path-g3.txt"));

        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        Map<Edge, Short> edgeMap = new HashMap<>();

        while(scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            int head = Integer.parseInt(line[0]);
            int tail = Integer.parseInt(line[1]);
            short cost = (short) Integer.parseInt(line[2]);

            edgeMap.put(new Edge(head,tail), cost);
        }

        short[][][] A =  new short[n+1][n+1][n+1];

        for(int u = 1; u <= n; u ++) {
            for(int w = 1; w <= n; w++) {
                if(u == w) {
                    A[0][u][w] = 0;
                } else {
                    A[0][u][w] = edgeMap.getOrDefault(new Edge(u, w), Short.MAX_VALUE);
                }
            }
        }

        for(int k = 1; k <= n; k++) {
            for(int u = 1; u <= n; u++) {
                for(int w = 1; w <= n; w++) {
                    short secondMember = (short) (A[k-1][u][k] + A[k-1][k][w]);

                    if(A[k-1][u][k] == Short.MAX_VALUE || A[k-1][k][w] == Short.MAX_VALUE) {
                        secondMember = Short.MAX_VALUE;
                    }

                    A[k][u][w] = (short) Math.min(A[k-1][u][w], secondMember);
                }
            }
        }

        for(int u = 1; u <= n; u++) {
            if(A[n][u][u] < 0) {
                System.out.println("This graph has a negative cycle!");
                return;
            }
        }

        //printGraph(A,n,n);
        System.out.println("Shortest path is: " + findShortestPath(A,n,n));
    }

    protected static void printGraph(short[][][] A, int n, int partition) {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                System.out.printf(" %5d ", A[partition][i][j]);
            }
            System.out.println();
        }
    }

    protected static int findShortestPath(short[][][] A, int n, int partition) {
        var shortestPath = Short.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <=n; j++) {
                shortestPath = (short) Math.min(shortestPath, A[partition][i][j]);
            }
        }
        return shortestPath;
    }
}
