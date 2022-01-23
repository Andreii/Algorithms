package solutions;

public class _70_Climbing_stairs {
    public int climbStairs(int n) {
        if(n<=1) return n;

        int[] dp = new int[n+1];

        dp[1] = 1; dp[2]=2;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }

    /**
     * Question   : Climbing Stairs
     * Complexity : Time: O(n) ; Space: O(1)
     */
    public int climbStairs2(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 2;

        for (int i = 3; i <= n; i++) {
            int newValue = prev1 + prev2;
            prev1 = prev2;
            prev2 = newValue;
        }

        return prev2;
    }
}

