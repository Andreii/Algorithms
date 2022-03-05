package module3_greedy.week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
In this programming problem and the next you'll code up the clustering algorithm from lecture for computing a
max-spacing kk-clustering.

Download the text file below.

Download file
This file describes a distance function (equivalently, a complete graph with edge costs).
It has the following format:

[number_of_nodes]

[edge 1 node 1] [edge 1 node 2] [edge 1 cost]

[edge 2 node 1] [edge 2 node 2] [edge 2 cost]

...

There is one edge (i,j) for each choice of 1 ≤ i < j ≤ n, where nn is the number of nodes.

For example, the third line of the file is "1 3 5250", indicating that the distance between nodes 1 and 3
(equivalently, the cost of the edge (1,3)) is 5250.  You can assume that distances are positive, but you
should NOT assume that they are distinct.

Your task in this problem is to run the clustering algorithm from lecture on this data set, where the target
number kk of clusters is set to 4.  What is the maximum spacing of a 4-clustering?

ADVICE: If you're not getting the correct answer, try debugging your algorithm using some small test cases.
And then post them to the discussion forum!
*/

public class Clustering {
    static class Edge {
        int v1, v2, cost;
        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        public String toString() {
            return v1 + "-" + v2 + " " + cost;
        }
    }

    static int find(int[] cluster, int vertex) {
        while(vertex != cluster[vertex]){
            vertex = cluster[vertex];
        }
        return vertex;
    }

    static int clusterMaxSpacing(List<Edge> edges, int[] cluster) {
        for(Edge edge : edges) {
            if(find(cluster, edge.v1) != find(cluster, edge.v2)) {
                return edge.cost;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception{
        Scanner scanner;

        List<Edge> edges = new ArrayList<>();

        scanner = new Scanner(new File("algorithms_illuminated/resources/clustering1.txt"));

        int count = Integer.parseInt(scanner.nextLine());
        int[] cluster = new int[count];

        for(int i = 0; i < count; i++) {
            cluster[i] = i;
        }

        while(scanner.hasNext()) {
            Integer[] items = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            edges.add(new Edge(items[0] - 1, items[1] - 1, items[2]));
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        int clusterSize = count;
        int k = 4;
        int[] sizes = new int[count];
        Arrays.fill(sizes, 1);

        for(Edge edge : edges) {
            int root1 = find(cluster, edge.v1);
            int root2 = find(cluster, edge.v2);

            if(clusterSize <= k) break;

            if(root1 == root2) {
                continue;
            }

            if(sizes[root1] <= sizes[root2]) {
                cluster[root1] = root2;
                sizes[root2] += sizes[root1];
            } else {
                cluster[root2] = root1;
                sizes[root1] += sizes[root2];
            }
            // merge
            clusterSize --;
        }

        System.out.println("K: " + clusterSize);
        System.out.println("Max spacing is: " + clusterMaxSpacing(edges, cluster));
    }
}
