package com.omtia.un;

import java.util.Arrays;

/**
 * Given an array of n integers nums and an integer target, find the number of index triplets i, j, k with
 * 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,0,1,3], target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 * [-2,0,1]
 * [-2,0,3]
 * Example 2:
 *
 * Input: nums = [], target = 0
 * Output: 0
 * Example 3:
 *
 * Input: nums = [0], target = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 0 <= n <= 3500
 * -100 <= nums[i] <= 100
 * -100 <= target <= 100
 */
public class _259_3sum_smaller {
    public int threeSumSmaller(int[] nums, int t) {
        int n = nums.length;
        if(n <= 2) return 0;
        int res = 0;

        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {
            int L = i+1, R=n-1;

            while(L<R){

                int sum = nums[i] + nums[L] + nums[R];

                if(sum<t) {
                    res+=R-L;
                    L++;
                } else {
                    R--;
                }
            }
        }

        return res;
    }
}
