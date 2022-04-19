package com.omtia.leetcode;

import org.junit.Test;
import com.omtia.un._347_top_k_frequent_elements;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;

public class _347_top_k_frequent_elementsTest {

    @Test
    public void testTopKFrequent() {
        _347_top_k_frequent_elements c = new _347_top_k_frequent_elements();

        int[] res = c.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        Arrays.sort(res);

        assertThat(res).isEqualTo(new int[]{1,2});
    }
}