package com.omtia.leetcode;

import org.junit.Test;
import com.omtia.un._215_kth_largest_element_in_an_array;

import static com.google.common.truth.Truth.assertThat;

public class _215_kth_largest_element_in_an_arrayTest {

    @Test
    public void test() {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        _215_kth_largest_element_in_an_array c = new _215_kth_largest_element_in_an_array();

        assertThat(c.findKthLargest(nums, k)).isEqualTo(5);
        assertThat(c.findKthLargest2(nums, k)).isEqualTo(5);
    }
}