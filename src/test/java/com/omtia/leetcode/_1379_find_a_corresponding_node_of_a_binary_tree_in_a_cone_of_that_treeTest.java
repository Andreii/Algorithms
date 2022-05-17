/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import com.omtia.un._1379_find_a_corresponding_node_of_a_binary_tree_in_a_cone_of_that_tree;
import com.omtia.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

class _1379_find_a_corresponding_node_of_a_binary_tree_in_a_cone_of_that_treeTest {

    @Test
    void getTargetCopy_shouldWorkForBaseCase() {
        // given two trees, one original and one cloned
        _1379_find_a_corresponding_node_of_a_binary_tree_in_a_cone_of_that_tree c =
                new _1379_find_a_corresponding_node_of_a_binary_tree_in_a_cone_of_that_tree();

        ArrayList<Integer> test = new ArrayList<>(Arrays.asList( 7,4,3,-1,-1,6,19 ));

        TreeNode original = buildNode(test, 0, test.size());
        TreeNode clone = buildNode(test, 0, test.size());

        // when looking up the clone tree
        TreeNode result = c.getTargetCopy(original, clone, original.right);

        // then we should receive the right cloned node
        assertThat(result).isEqualTo(clone.right);
    }

    protected TreeNode buildNode(List<Integer> nums, int L, int R) {
        if(nums.size() == 0 || nums.get(0) == -1 || L > R) {
            return null;
        }

        TreeNode node = new TreeNode(nums.get(0));

        node.left = buildNode(nums, L + 1, R);
        node.right = buildNode(nums, L + 2, R);

        return node;
    }
}