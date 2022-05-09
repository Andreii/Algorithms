/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import com.omtia.un._64_minimum_path_sum;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class _64_minimum_path_sumTest {

    @Test
    void minPathSum_shouldWorkForBaseCase() {
        _64_minimum_path_sum c = new _64_minimum_path_sum();
        int[][] grid = new int[][] {{1,3,1}, {1,5,1}, {4,2,1}};

        assertThat(c.minPathSum(grid)).isEqualTo(7);
    }
}