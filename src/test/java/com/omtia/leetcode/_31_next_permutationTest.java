package com.omtia.leetcode;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class _31_next_permutationTest {

    @Ignore
    void nextPermutation() {
        _31_next_permutation c = new _31_next_permutation();
        int[] test = new int[] {2,3,1,3,3};
        int[] test2 = new int[] {1,2,3};

        c.nextPermutation(test);
        c.nextPermutation(test2);

        assertThat(test).isEqualTo(new int[] {2,3,3,1,3});
        assertThat(test2).isEqualTo(new int[] {1,3,2});
    }
}