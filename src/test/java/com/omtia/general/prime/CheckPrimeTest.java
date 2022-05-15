/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.general.prime;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CheckPrimeTest {

    @Test
    void isPrime_shouldWorkForBaseCase() {
        CheckPrime c = new CheckPrime();

        assertThat(c.isPrime(11)).isTrue();
        assertThat(c.isPrime((int) (1e9+7))).isTrue();
        assertThat(c.isPrime( (1<<31) - 1 )).isTrue();
    }

    @Test
    void isPrime_shouldFailForNotPrime() {
        CheckPrime c = new CheckPrime();

        assertThat(c.isPrime(63)).isFalse();
        assertThat(c.isPrime((int) 1e6 + 7)).isFalse();
        assertThat(c.isPrime((int) 1e9)).isFalse();
    }
}