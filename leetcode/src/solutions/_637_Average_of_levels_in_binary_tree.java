package solutions;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
