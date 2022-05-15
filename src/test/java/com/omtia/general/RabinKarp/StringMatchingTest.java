package com.omtia.general.RabinKarp;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class StringMatchingTest {

    @Test
    void computeRollingHash_worksForBaseCase() {
        StringMatching c = new StringMatching();

        assertThat(c.computeRollingHash("tte")).isEqualTo(new int[] {116, 15312, 1748573});
    }
}