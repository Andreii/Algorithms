/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import com.omtia.utils.TreeNode;

import java.util.LinkedList;

public class _1379_find_a_corresponding_node_of_a_binary_tree_in_a_cone_of_that_tree {

    // TC: O(n)
    // SC: O(n)
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode original_c = original;
        TreeNode cloned_c = cloned;

        LinkedList<TreeNode> qo = new LinkedList<>();
        LinkedList<TreeNode> qc = new LinkedList<>();

        qo.offer(original_c);
        qc.offer(cloned_c);

        while(!qo.isEmpty()) {
            int size = qo.size();

            for(int i = 0; i < size; i++) {
                TreeNode curr_o = qo.poll();
                TreeNode curr_c = qc.poll();

                if(curr_o.equals(target)) {
                    return curr_c;
                }

                if(curr_o.left != null) {
                    qo.offer(curr_o.left);
                    qc.offer(curr_c.left);
                }

                if(curr_o.right != null) {
                    qo.offer(curr_o.right);
                    qc.offer(curr_c.right);
                }
            }
        }

        return null;
    }
}