/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.general.prime;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class SieveOfErathosthenesTest {

    @Test
    void sieve_checkBaseCase() {
        SieveOfEratosthenes s = new SieveOfEratosthenes();

        long[] result = s.sieve(50).stream().mapToLong(l -> l).toArray();

        assertThat(result).isEqualTo(new long[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47});
    }
}