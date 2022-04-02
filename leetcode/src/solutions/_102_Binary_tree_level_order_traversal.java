package solutions;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right,
 * level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
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
 * -1000 <= Node.val <= 1000
 */
public class _102_Binary_tree_level_order_traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        if(root == null) return ans;

        q.add(root);

        while(!q.isEmpty()) {

            List<Integer> segment = new ArrayList<>();
            int n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                segment.add(cur.val);
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
            ans.add(segment);
        }

        return ans;
    }
}
