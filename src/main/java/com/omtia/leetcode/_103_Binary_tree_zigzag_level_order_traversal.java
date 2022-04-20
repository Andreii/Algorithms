/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import com.omtia.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to
 * right, then right to left for the next level and alternate between).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 * Accepted
 * 677,136
 * Submissions
 * 1,271,381
 */
public class _103_Binary_tree_zigzag_level_order_traversal {
    // TC: O(n)
    // SC: O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();

        if(root == null) return ans;

        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {

            List<Integer> segment = new ArrayList<>();
            int n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode cur;
                cur = q.poll();
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
                segment.add(cur.val);

            }
            if(level % 2 == 1) {
                Collections.reverse(segment);
            }

            ans.add(segment);
            level++;
        }

        return ans;
    }
}
