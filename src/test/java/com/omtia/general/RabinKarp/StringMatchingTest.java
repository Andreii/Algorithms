package com.omtia.general.RabinKarp;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class StringMatchingTest {

    @Test
    void computeRollingHash() {
        StringMatching classz = new StringMatching();

        assertThat(classz.computeRollingHash("tte")).isEqualTo(new int[] {116, 15312, 1748573});
    }
}