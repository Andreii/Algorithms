/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.general.dynamic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;

class FibonacciTest {
    // 0 1 1 2 3 5 8 13 21
    // 0 1 2 3 4 5 6 7  8

    @Test
    void nth_fib() {
        // given
        Fibonacci c = new Fibonacci();

        // when
        int result = c.nth_fib(8);

        // then
        assertThat(result).isEqualTo(21);
    }

    @Test
    void nth_fib_recursive() {
        // given
        Fibonacci c = new Fibonacci();

        // when
        int result = c.nth_fib_recursive(8);

        // then
        assertThat(result).isEqualTo(21);
    }


    @Test
    void nth_fib_recursive_memo() {
        // given
        Fibonacci c = new Fibonacci();
        int n = 8;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);

        // when
        int result = c.nth_fib_recursive_memo(n, memo);

        // then
        assertThat(result).isEqualTo(21);
    }

    @Test
    void nth_fib_dp_constant_time() {
        // given
        Fibonacci c = new Fibonacci();

        // when
        int result = c.nth_fib_dp_constant_time(8);

        // then
        assertThat(result).isEqualTo(21);
    }
}