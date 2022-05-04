/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import com.omtia.un._264_ugly_numbers_2;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class _264_ugly_numbers_2Test {

    @Test
    void nthUglyNumber_shouldWorkSimpleCase() {
        _264_ugly_numbers_2 c = new _264_ugly_numbers_2();
        int result = c.nthUglyNumber(2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void nthUglyNumber_shouldWorkForBaseCase() {
        _264_ugly_numbers_2 c = new _264_ugly_numbers_2();
        int result = c.nthUglyNumber(10);
        assertThat(result).isEqualTo(12);
    }
}