/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import com.omtia.un._169_majority_element;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class _169_majority_elementTest {

    @Test
    void majorityElement_shouldWorkForBaseCase() {
        _169_majority_element c = new _169_majority_element();

        int result  = c.majorityElement(new int[] { 2,2,1,1,1,2,2 });
        int result2 = c.majorityElement(new int[] { 7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5 });

        assertThat(result).isEqualTo(2);
        assertThat(result2).isEqualTo(5);
    }
}