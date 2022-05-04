package com.omtia.un;

public class _746_min_cost_climbing_stairs {
    //    n-2  n-1 n
    // 10, 15, 20, 0

    // TC: O(n)
    // SC: O(n)
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n+1];
        for(int i = 0; i < n; i++) {
            dp[i] = cost[i];
        }

        for( int i = n-3; i >= 0; i--) {
            dp[i] += Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);
    }

    // TC: O(n)
    // SC: O(1)
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;

        for( int i = n-2; i >= 0; i--) {
            cost[i] += Math.min(i+1 == n ? 0 : cost[i+1], i+2 == n ? 0 : cost[i+2]);
        }

        return Math.min(cost[0], cost[1]);
    }
}
