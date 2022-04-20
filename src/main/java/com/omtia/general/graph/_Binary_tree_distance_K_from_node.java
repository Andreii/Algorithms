/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.general.graph;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.LinkedList;
import java.util.ArrayList;

class _Binary_tree_distance_K_from_node {

    protected static int bfs(Node root, Node target, int k, List<Node> ans) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);

        int level = 1;
        int foundLevel = 1;
        boolean levelFound = false;
        while(!q.isEmpty()) {
            int n = q.size();

            for(int i = 0; i < n; i++) {
                Node curr = q.poll();
                if(levelFound && (Math.abs(foundLevel - level) == k)) {
                    ans.add(curr);
                }
                if(!levelFound && curr.val == target.val) {
                    q = new LinkedList<>();
                    q.add(root);
                    levelFound = true;
                    foundLevel = level;
                    level = 0;
                    break;
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            level++;
        }

        return -1;
    }

    public static List<Node> getDistanceKNodes(Node root, Node target, int k) {
        List<Node> ans = new ArrayList<>();
        if(root == null) return ans;
        bfs(root,target,k,ans);
        return ans;
    }


    /** Driver class, do not change **/
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }

        public static Node buildTree(Iterator<String> iter) {
            String nxt = iter.next();
            if (nxt.equals("x")) return null;
            Node node = new Node(Integer.parseInt(nxt));
            node.left = buildTree(iter);
            node.right = buildTree(iter);
            return node;
        }

        public static Node findNode(Node root, int target) {
            if (root == null || root.val == target) return root;
            Node leftSearch = findNode(root.left, target);
            if (leftSearch != null) return leftSearch;
            return findNode(root.right, target);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Node root = Node.buildTree(Arrays.stream(scanner.nextLine().split(" ")).iterator());
        Node target = Node.findNode(root, Integer.parseInt(scanner.nextLine()));
        int k = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<Node> res = getDistanceKNodes(root, target, k);
        System.out.println(res.stream().map(node -> Integer.toString(node.val)).collect(Collectors.joining(" ")));
    }

}