package solutions;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
 * you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
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
public class _199_Binary_tree_right_side_view {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        LinkedList<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            ans.add(q.peekLast().val);
            int n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
        }

        return ans;
    }
}
