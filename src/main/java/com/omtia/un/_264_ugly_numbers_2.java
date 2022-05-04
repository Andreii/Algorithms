/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return the nth ugly number.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1690
 * Accepted
 * 257,146
 * Submissions
 * 568,170
 */
public class _264_ugly_numbers_2 {

    // TC: O(ans) where ans is the n-th elem
    // SC: O(ans) where ans is the n-th elem
    public int nthUglyNumber(int n) {
        int[] primes = new int[] {2,3,5};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        pq.offer(1);
        visited.add(1);

        for(int i = 0; i < n - 1; i ++) {
            Integer curr = pq.poll();
            for(int prime : primes) {
                if(!visited.contains(curr * prime)) {
                    visited.add(curr * prime);
                    pq.offer(curr * prime);
                }
            }
        }

        return pq.poll();
    }
}
