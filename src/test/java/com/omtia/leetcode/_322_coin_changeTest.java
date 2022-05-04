/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import com.omtia.un._322_coin_change;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class _322_coin_changeTest {

    @Test
    void coinChange_shouldClearBaseCase() {
        // given
        _322_coin_change c = new _322_coin_change();

        // when
        int result = c.coinChange(new int[] {1,2,5}, 11);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void coinChange_shouldFailInvalid() {
        // given
        _322_coin_change c = new _322_coin_change();

        // when
        int result = c.coinChange(new int[] {2}, 3);

        // then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void coinChange_shouldFailOnZero() {
        // given
        _322_coin_change c = new _322_coin_change();

        // when
        int result = c.coinChange(new int[] {1}, 0);

        // then
        assertThat(result).isEqualTo(0);
    }
}