/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.general.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int name;
    protected List<Node> children;

    public Node(int name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public Node addChild(Node node) {
        this.children.add(node);
        return node;
    }

    public List<Node> getAdjacent() {
        return children;
    }
}
