/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import com.omtia.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 *
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5]
 * Output: [[4,5,3],[2],[1]]
 * Explanation:
 * [[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter
 * the order on which elements are returned.
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 */
// WIP
public class _366_find_leaves_of_binary_tree {
    // TC: O(n)
    // SC: O(n)
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    protected int dfs(TreeNode node, List<List<Integer>> res) {
        if(node == null) return -1;

        int level = 1 + Math.max(dfs(node.left, res), dfs(node.right, res));

        if(res.size() == level) res.add(new ArrayList<>());

        res.get(level).add(node.val);

        return level;
    }
}
