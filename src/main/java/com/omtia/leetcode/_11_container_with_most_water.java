package com.omtia.leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
 * the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
 * water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class _11_container_with_most_water {
    // TC: O(n)
    // SC: O(1)
    public int maxArea(int[] height) {
        // loop through all possibilities
        int max = Integer.MIN_VALUE;
        int n = height.length, L = 0, R = n - 1;

        while(L<R) {
            max = Math.max(max, area(L, R, height));

            if(height[L] < height[R]) {
                L++;
            } else {
                R--;
            }
        }

        return max;
    }

    // area(a,b) = min(a,b) + dist(a,b)
    protected int area(int L, int R, int[] height) {
        return Math.min(height[L], height[R]) * (R-L);
    }
}
