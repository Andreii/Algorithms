/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.algorithmsIlluminated.module3_greedy.week2;

import java.io.File;
import java.util.*;

/*  In this question your task is again to run the clustering algorithm from lecture, but on a MUCH bigger graph.
    So big, in fact, that the distances (i.e., edge costs) are only defined implicitly, rather than being provided as
    an explicit list.

    The data set is below.


    The format is:

    [# of nodes] [# of bits for each node's label]

    [first bit of node 1] ... [last bit of node 1]

    [first bit of node 2] ... [last bit of node 2]

    ...

    For example, the third line of the file "0 1 1 0 0 1 1 0 0 1 0 1 1 1 1 1 1 0 1 0 1 1 0 1" denotes the 24 bits
    associated with node #2.

    The distance between two nodes uu and vv in this problem is defined as the Hamming distance--- the number of
    differing bits --- between the two nodes' labels.  For example, the Hamming distance between the 24-bit label of
    node #2 above and the label "0 1 0 0 0 1 0 0 0 1 0 1 1 1 1 1 1 0 1 0 0 1 0 1" is 3 (since they differ in the 3rd,
    7th, and 21st bits).

    The question is: what is the largest value of k such that there is a k-clustering with spacing at least 3?
    That is, how many clusters are needed to ensure that no pair of nodes with all but 2 bits in common get split
    into different clusters?

    NOTE: The graph implicitly defined by the data file is so big that you probably can't write it out explicitly,
    let alone sort the edges by cost.  So you will have to be a little creative to complete this part of the question.
    For example, is there some way you can identify the smallest distances without explicitly looking at every pair
     of nodes?
*/
public class Clustering_big {
    static int[] parent;
    static int[] size;
    static int clusterSize;

    static int find(int vertex) {
        while(parent[vertex] != vertex) {
            vertex = parent[vertex];
        }
        return vertex;
    }

    static void union(int vertex1, int vertex2) {
        int root1 = find(vertex1);
        int root2 = find(vertex2);

        if(root1 == root2) return;
        if(size[root1] <= size[root2]) {
            parent[root1] = root2;
            size[root2] += size[root1];
        } else {
            parent[root2] = root1;
            size[root1] += size[root2];
        }
        clusterSize --;
    }

    static int toInteger(BitSet bs) {
        int answer = 0;
        for(int i = 0; i < bs.length(); i++) {
            answer += bs.get(i) ? 1 << i : 0;
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = null;
        //            scanner = new Scanner(new File("algorithms_illuminated/resources/clustering_big.txt"));
        scanner = new Scanner(new File("algorithms_illuminated/resources/clustering_big.txt"));

        String[] information = scanner.nextLine().split(" ");
        int vertexCount = Integer.parseInt(information[0]);
        int bitCount = Integer.parseInt(information[1]);
        clusterSize = vertexCount;

        List<BitSet> vertexes = new ArrayList<>();
        while(scanner.hasNext()) {
            BitSet bs = new BitSet();
            int[] line = Arrays.
                    stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for(int i = 0; i < line.length; i++) {
                if(line[i] == 1) bs.set(i);
            }

            vertexes.add(bs);
        }

        parent = new int[vertexCount];
        for(int i = 0; i < vertexCount; i++) {
            parent[i] = i;
        }

        size = new int[vertexCount];
        Arrays.fill(size, 1);

        // zero
        Map<BitSet, Integer> zero_distance = new HashMap<>();
        for(int i = 0; i < vertexes.size(); i++) {
            BitSet bs = vertexes.get(i);

            if(zero_distance.containsKey(bs)) {
                union(i, zero_distance.get(bs));
            } else {
                zero_distance.put(bs, i);
            }
        }

        for(Map.Entry<BitSet, Integer> entry : zero_distance.entrySet()) {
            BitSet bs = entry.getKey();
            Integer i = entry.getValue();

            for(int j = 0; j < bitCount; j++) {
                bs.flip(j);
                if(zero_distance.containsKey(bs)) {
                    union(i, zero_distance.get(bs));
                }
                for(int k = 0; k < bitCount; k++) {
                    bs.flip(k);
                    if (zero_distance.containsKey(bs)) {
                        union(i, zero_distance.get(bs));
                    }
                    bs.flip(k);
                }
                bs.flip(j);
            }
        }

        System.out.println("Cluster size is: -> " + clusterSize);
    }
}
