package com.omtia.leetcode;

import com.omtia.un._746_min_cost_climbing_stairs;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class _746_min_cost_climbing_stairsTest {

    @Test
    void minCostClimbingStairs_shouldWorkForBaseCase() {
        // given
        _746_min_cost_climbing_stairs c = new _746_min_cost_climbing_stairs();

        // when
        int result = c.minCostClimbingStairs(new int[] {10,15,20});

        // then
        assertThat(result).isEqualTo(15);
    }

    @Test
    void minCostClimbingStairs_shouldWorkForBaseCase2() {
        // given
        _746_min_cost_climbing_stairs c = new _746_min_cost_climbing_stairs();

        // when
        int result = c.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1});

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void minCostClimbingStairs2_shouldWorkForBaseCase() {
        // given
        _746_min_cost_climbing_stairs c = new _746_min_cost_climbing_stairs();

        // when
        int result = c.minCostClimbingStairs2(new int[] {10,15,20});

        // then
        assertThat(result).isEqualTo(15);
    }

    @Test
    void minCostClimbingStairs2_shouldWorkForBaseCase2() {
        // given
        _746_min_cost_climbing_stairs c = new _746_min_cost_climbing_stairs();

        // when
        int result = c.minCostClimbingStairs2(new int[] {1,100,1,1,1,100,1,1,100,1});

        // then
        assertThat(result).isEqualTo(6);
    }
}