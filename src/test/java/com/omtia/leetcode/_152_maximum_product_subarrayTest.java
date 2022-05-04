/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import com.omtia.un._152_maximum_product_subarray;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class _152_maximum_product_subarrayTest {

    @Test
    void maxProduct_shouldWorkForBestCase() {
        // given
        _152_maximum_product_subarray c = new _152_maximum_product_subarray();

        // when
        int[] testArr = new int[]{ 2,3,-2,4 };
        int result = c.maxProduct(testArr);
        int result2 = c.maxProductBrute(testArr);

        // then
        assertThat(result).isEqualTo(6);
        assertThat(result2).isEqualTo(6);
    }

    @Test
    void maxProduct_shouldWorkForZero() {
        // given
        _152_maximum_product_subarray c = new _152_maximum_product_subarray();

        // when
        int[] testArr = new int[]{ -2,0,-1 };
        int result = c.maxProduct(testArr);
        int result2 = c.maxProductBrute(testArr);

        // then
        assertThat(result).isEqualTo(0);
        assertThat(result2).isEqualTo(0);
    }
}