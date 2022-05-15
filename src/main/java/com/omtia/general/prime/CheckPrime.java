/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.general.prime;

public class CheckPrime {
    // TC: O(sqrt(n))
    // SC: O(1)
    boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }

        int N = (int) Math.sqrt(n);

        if(n % 2 == 0) return false;

        for(int i = 3; i < N; i += 2) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
