package graph;

import java.util.Arrays;

public class Graph {
    Node[] nodes;
    public Graph(int n) {
        this.nodes = new Node[n];
        Arrays.fill(nodes, new Node(0));
    }

    public Node get(int i) {
        return nodes[i];
    }
}
