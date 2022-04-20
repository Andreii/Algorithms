/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import com.omtia.utils.TreeNode;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class _226_Invert_binary_tree {
    public void invertDFS(TreeNode root) {
        if(root == null) return;

        invertDFS(root.left);
        invertDFS(root.right);

        if(root.left != null || root.right != null) {
            TreeNode z = root.left;
            root.left = root.right;
            root.right = z;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        invertDFS(root);
        return root;
    }
}
