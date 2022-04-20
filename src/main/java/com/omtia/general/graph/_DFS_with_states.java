/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.general.graph;

import java.util.*;

/**
 * Given a ternary tree (each node of the tree has at most three children), find all root-to-leaf paths.
 *          1
 *        / | \
 *       2  4  6
 *      /
 *     3
 *
 *     [
 *       1->2->3,
 *       1->4,
 *       1->6
 *     ]
 */
class _DFS_with_states {
    public static void dfs(Node root, List<String> arr, List<String> path) {
        if(root.children[0] == null &&
                root.children[1] == null &&
                root.children[2] == null) {

            path.add(Integer.toString(root.val));
            arr.add(String.join("->", path));
            path.remove(Integer.toString(root.val));
            return ;
        }

        for(Node child : root.children) {
            if(child != null) {
                path.add(Integer.toString(root.val));
                dfs(child,arr,path);
                path.remove(Integer.toString(root.val));
            }
        }
    }

    public static String[] ternaryTreePaths(Node root) {
        if(root == null) return new String[0];
        List<String> res = new ArrayList<>();
        dfs(root,res,new ArrayList<>());
        return res.toArray(new String[res.size()]);
    }

    /** Driver class, do not change **/
    static class Node {
        int val;
        Node[] children;

        public Node(int val, Node[] children) {
            this.val = val;
            this.children = children;
        }

        public static Node buildTree(Iterator<String> nodes) {
            String nxt = nodes.next();
            if (nxt.equals("x")) return null;
            Node node = new Node(Integer.parseInt(nxt), new Node[3]);
            for (int i = 0; i < 3; i++) {
                node.children[i] = buildTree(nodes);
            }
            return node;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = Node.buildTree(Arrays.stream(scanner.nextLine().split(" ")).iterator());
        scanner.close();
        String[] paths = ternaryTreePaths(root);
        for (String path : paths) {
            System.out.println(path);
        }
    }

}
