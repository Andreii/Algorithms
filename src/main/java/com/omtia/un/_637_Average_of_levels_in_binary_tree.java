/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import com.omtia.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
 * Answers within 10-5 of the actual answer will be accepted.
 *
 *
 * Example 1:
 *       3
 *     /  \
 *    9    20
 *        /  \
 *      15    7
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * Example 2:
 *       3
 *     /  \
 *    9    20
 *   / \
 *  15  7
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */

public class _637_Average_of_levels_in_binary_tree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();

        if(root == null) return res;

        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();

            double sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                sum += cur.val;
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            res.add(sum/size);
        }
        return res;
    }
}
