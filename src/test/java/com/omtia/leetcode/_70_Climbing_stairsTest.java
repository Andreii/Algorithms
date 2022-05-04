package com.omtia.leetcode;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class _70_Climbing_stairsTest {

    // 1 2 3 5 8 13 21
    // 1 2 3 4 5 6  7
    @Test
    void climbStairs_shouldWorkForBaseCase() {
        // given
        _70_Climbing_stairs c = new _70_Climbing_stairs();

        // when
        int result = c.climbStairs(7);

        // then
        assertThat(result).isEqualTo(21);
    }

    @Test
    void climbStairs2_shouldWorkForBaseCase() {
        // given
        _70_Climbing_stairs c = new _70_Climbing_stairs();

        // when
        int result = c.climbStairs2(7);

        // then
        assertThat(result).isEqualTo(21);
    }
}