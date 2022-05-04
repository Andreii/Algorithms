/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import com.omtia.un._295_Find_Median_from_data_stream;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class _295_Find_Median_from_data_streamTest {

    @Test
    public void findMedian_testBestCase() {
        // given
        _295_Find_Median_from_data_stream c = new _295_Find_Median_from_data_stream();

        // when
        c.addNum(1);
        c.addNum(2);

        // then
        double result = c.findMedian();
        assertThat(result).isEqualTo(1.5);
    }

    @Test
    public void findMedian_testBestCase2() {
        // given
        _295_Find_Median_from_data_stream c = new _295_Find_Median_from_data_stream();

        // when
        c.addNum(1);
        c.addNum(2);
        c.addNum(3);

        // then
        double result = c.findMedian();
        assertThat(result).isEqualTo(2.0);
    }
}