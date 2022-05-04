/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import com.omtia.un._50_powxn;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class _50_powxnTest {

    @Test
    void myPow() {
        _50_powxn c = new _50_powxn();

        double result = c.myPow(2.0d, -2147483648);

        assertThat(result).isEqualTo(0);
    }
}