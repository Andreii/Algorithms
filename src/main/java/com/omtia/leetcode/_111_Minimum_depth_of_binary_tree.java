/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import com.omtia.utils.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * Example 2:
 *
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 */

public class _111_Minimum_depth_of_binary_tree {
    // TC: O(n)
    // SC: O(n)
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int minHeight = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {

                TreeNode cur = queue.poll();

                if(cur.left == null && cur.right == null) {
                    return minHeight;
                }

                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }

            minHeight++;
        }

        return minHeight;
    }

    // TC: O(n)
    // SC: O(n)
    public int minDepth3(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 1;
        while(!q.isEmpty()) {

            int n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                if(cur.left == null && cur.right == null) return level;
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }

            level++;
        }

        return -1;
    }

    // TC: O(n)
    // SC: O(n)
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }
}
