package solutions;

import java.util.LinkedList;

public class _111_Minimum_depth_of_binary_tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
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

        public int minDepth2(TreeNode root) {
            if(root == null) return 0;
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
        }
    }
}
