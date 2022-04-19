package com.omtia.leetcode;

import org.junit.Test;
import com.omtia.un._378_kth_smallest_element_in_a_sorted_matrix;

import static com.google.common.truth.Truth.assertThat;

public class _378_kth_smallest_element_in_a_sorted_matrixTest {

    @Test
    public void testKthSmallest() {
        _378_kth_smallest_element_in_a_sorted_matrix c = new _378_kth_smallest_element_in_a_sorted_matrix();

        assertThat(c.kthSmallest(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}}, 8)).isEqualTo(13);
        assertThat(c.kthSmallest2(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}}, 8)).isEqualTo(13);
    }
}