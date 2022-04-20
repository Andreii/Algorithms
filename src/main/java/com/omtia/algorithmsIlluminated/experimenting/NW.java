/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.algorithmsIlluminated.experimenting;

public class NW {
    public static void main(String[] args) {
        String A = "AGTACG";
        String B = "ACATAG";

        System.out.printf("NW Score is: [%d]", NW(A,B,0,1,3));
    }

    /**
     * Needleman-Wunsch algorithm for calculating genome distance
     *
     * @param A
     * @param B
     * @param diffPenalty
     * @param gapPenalty
     * @return
     */
    public static int NW(String A, String B, int match, int diffPenalty, int gapPenalty) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = i * gapPenalty;
        }

        for(int j = 0; j <= m; j++) {
            dp[0][j] = j * gapPenalty;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                int penalty = diffPenalty;
                if(A.charAt(i-1) == B.charAt(j-1)) {
                    penalty = match;
                }

                int diff = dp[i - 1][j - 1] + penalty;
                int gapA = dp[i - 1][j] + gapPenalty;
                int gapB = dp[i][j-1] + gapPenalty;

                dp[i][j] = Math.min(Math.min(diff, gapA), gapB);
            }
        }

        return dp[n][m];
    }
}
