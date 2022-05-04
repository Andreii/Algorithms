/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import com.omtia.un._198_house_robber;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class _198_house_robberTest {

    @Test
    void rob_executeBestCase() {
        // given
        _198_house_robber c = new _198_house_robber();

        // when
        int result = c.rob(new int[]{2,7,9,3,1});

        // then
        assertThat(result).isEqualTo(12);
    }
}