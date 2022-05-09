/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes
 * the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class _64_minimum_path_sum {
    // top down
    //  dp[i][j] = grid[i][j] + min(dp[i][j-1], dp[i-1][j])
    // bottom up
    //  dp[i][j] = grid[i][j] + min(dp[i+1][j], dp[i][j+1])

    // TC: O(mn)
    // SC: O(mn)
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];

        for(int[] col : dp) {
            Arrays.fill(col, -1);
        }

        dp[0][0] = grid[0][0];

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j++) {
                if(i+1 < m && dp[i+1][j] != -1) {
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + grid[i+1][j]);
                } else if(i+1 < m) {
                    dp[i+1][j] = dp[i][j] + grid[i+1][j];
                }

                if(j+1 < n && dp[i][j+1] != -1) {
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + grid[i][j+1]);
                } else if(j+1 < n) {
                    dp[i][j+1] = dp[i][j] + grid[i][j+1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
