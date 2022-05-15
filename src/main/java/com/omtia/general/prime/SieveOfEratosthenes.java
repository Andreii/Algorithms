/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.general.prime;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class SieveOfEratosthenes {

    public List<Long> sieve(int limit) {
        int LIMIT = limit + 10;

        BitSet bs = new BitSet(LIMIT);
        bs.set(0, LIMIT, true);
        bs.clear(0, 1);

        List<Long> primes = new ArrayList<>();
        for(long i = 2; i <= limit; i++) {
            if(bs.get( (int) i)) {
                for(long j = i*i; j <= limit; j += i) {
                    bs.clear( (int) j);
                }
                primes.add(i);
            }
        }

        return primes;
    }
}
