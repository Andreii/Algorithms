/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.general.dynamic;

public class Fibonacci {
    // TC: O(n)
    // SC: O(n)
    public int nth_fib(int n) {
        if(n <= 1) {
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }

    // TC: O(n)
    // SC: O(n)
    public int nth_fib_recursive(int n) {
        if( n <= 1 ) {
            return n;
        }

        return nth_fib_recursive(n - 2) + nth_fib_recursive(n - 1);
    }

    // TC: O(n)
    // SC: O(n)
    public int nth_fib_recursive_memo(int n, int[] memo) {
        if(memo[n] != -1) {
            return memo[n];
        }

        if(n <= 1) {
            return n;
        }

        memo[n] = nth_fib_recursive_memo(n-2, memo) + nth_fib_recursive_memo(n-1, memo);

        return memo[n];
    }

    // TC: O(n)
    // SC: O(1)
    public int nth_fib_dp_constant_time(int n) {
        if(n <= 1) return n;

        // prev 2 < prev 1 < curr
        int prev2 = 0;
        int prev1 = 1;
        int res = 0;

        for( int i = 2; i <= n; i++) {
            res = prev2 + prev1;
            prev2 = prev1;
            prev1 = res;
        }

        return res;
    }
}