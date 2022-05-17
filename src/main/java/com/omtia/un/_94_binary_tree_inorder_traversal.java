/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import com.omtia.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class _94_binary_tree_inorder_traversal {

    // TC: O(n)
    // SC: O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();

        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null || !q.isEmpty()) {
            while(curr != null) {
                q.offer(curr);
                curr = curr.left;
            }

            curr = q.pollLast();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }

    // TC: O(n)
    // SC: O(1)
    // modifies input
    public List<Integer> inorderTraversalMorris(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();

        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }

        return res;
    }
}
