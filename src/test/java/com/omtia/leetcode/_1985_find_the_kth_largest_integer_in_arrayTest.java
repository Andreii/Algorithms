package com.omtia.leetcode;

import org.junit.Test;
import com.omtia.un._1985_find_the_kth_largest_integer_in_array;

import static com.google.common.truth.Truth.assertThat;

public class _1985_find_the_kth_largest_integer_in_arrayTest {

    @Test
    public void testKthLargestNumber() {
        String[] nums = {"3","6","7","10"};
        String[] nums2 = {"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"};

        _1985_find_the_kth_largest_integer_in_array c = new _1985_find_the_kth_largest_integer_in_array();

        assertThat(c.kthLargestNumber(nums, 4)).isEqualTo("3");
        assertThat(c.kthLargestNumber(nums2, 11)).isEqualTo("695");
    }
}