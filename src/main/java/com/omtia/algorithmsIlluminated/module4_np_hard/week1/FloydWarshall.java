/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.algorithmsIlluminated.module4_np_hard.week1;

import java.util.*;
import java.io.File;

/**
 * The first line indicates the number of vertices and edges, respectively.  Each subsequent line describes an edge
 * (the first two numbers are its tail and head, respectively) and its length (the third number).  NOTE: some of the
 * edge lengths are negative.  NOTE: These graphs may or may not have negative-cost cycles.
 *
 * Your task is to compute the "shortest shortest path".  Precisely, you must first identify which, if any, of the three
 * graphs have no negative cycles.  For each such graph, you should compute all-pairs shortest paths and remember the
 * smallest one (i.e., compute \min_{u,v \in V} d(u,v)min
 * u,v∈V
 * ​
 *  d(u,v), where d(u,v)d(u,v) denotes the shortest-path distance from uu to vv).
 *
 * If each of the three graphs has a negative-cost cycle, then enter "NULL" in the box below.  If exactly one graph has
 * no negative-cost cycles, then enter the length of its shortest shortest path in the box below.  If two or more of the
 * graphs have no negative-cost cycles, then enter the smallest of the lengths of their shortest shortest paths in the
 * box below.
 *
 * OPTIONAL: You can use whatever algorithm you like to solve this question.  If you have extra time, try comparing the
 * performance of different all-pairs shortest-path algorithms!
 *
 * OPTIONAL: Here is a bigger data set to play with.
 */
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
        Scanner scanner = new Scanner(new File("algorithms_illuminated/resources/all-paths-shortest-path-g3.txt"));

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
