/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import com.omtia.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class _366_find_leaves_of_binary_treeTest {

    @Test
    void findLeaves() {
        _366_find_leaves_of_binary_tree c = new _366_find_leaves_of_binary_tree();

        assertThat(c.findLeaves(new TreeNode(1))).isEqualTo(List.of(List.of(1)));
    }
}