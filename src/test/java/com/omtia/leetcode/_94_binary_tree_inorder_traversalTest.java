/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import com.omtia.un._94_binary_tree_inorder_traversal;
import com.omtia.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class _94_binary_tree_inorder_traversalTest {

    @Test
    void inorderTraversal_shouldWorkForBaseCase() {
        _94_binary_tree_inorder_traversal c = new _94_binary_tree_inorder_traversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = c.inorderTraversal(root);

        assertThat(result).isEqualTo(List.of(1,3,2));
    }

    @Test
    void inorderTraversalMorris_shouldWorkForBaseCase() {
        _94_binary_tree_inorder_traversal c = new _94_binary_tree_inorder_traversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = c.inorderTraversalMorris(root);

        assertThat(result).isEqualTo(List.of(1,3,2));
    }
}