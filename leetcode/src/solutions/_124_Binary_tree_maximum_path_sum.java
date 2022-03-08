package solutions;

import utils.TreeNode;

public class _124_Binary_tree_maximum_path_sum {
    class Solution {
        public int answer;

        public int dfs(TreeNode node) {
            if(node == null) return 0;

            int left = dfs(node.left);
            int right = dfs(node.right);

            answer = Math.max(answer, left + right + node.val);

            return Math.max(0, node.val + Math.max(left, right));
        }

        public int maxPathSum(TreeNode root) {
            answer = Integer.MIN_VALUE;

            dfs(root);

            return answer;
        }
    }
}
