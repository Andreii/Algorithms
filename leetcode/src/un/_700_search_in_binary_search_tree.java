package un;

import utils.TreeNode;

import java.util.LinkedList;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a
 * node does not exist, return null.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 * Example 2:
 *
 *
 * Input: root = [4,2,7,1,3], val = 5
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 5000].
 * 1 <= Node.val <= 107
 * root is a binary search tree.
 * 1 <= val <= 107
 */
public class _700_search_in_binary_search_tree {
    // BFS brute force
    // TC: O(n)
    // SC: O(n)
    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val == val) return root;

        LinkedList<TreeNode> q = new LinkedList<>();
        q.push(root);

        while(!q.isEmpty()) {
            TreeNode node = q.pop();

            if(node.val == val) return node;
            if(node.left != null) q.push(node.left);
            if(node.right != null) q.push(node.right);
        }

        return null;
    }

    // TC: O(H) -> H = tree height, O(logN) average O(n) worst
    // SC: O(1)
    public TreeNode searchBST2(TreeNode root, int val) {
        while(root != null) {
            if(root.val == val) return root;
            if(root.val < val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return root;
    }
}
