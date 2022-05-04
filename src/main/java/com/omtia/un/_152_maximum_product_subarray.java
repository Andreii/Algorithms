/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
 * and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 */
public class _152_maximum_product_subarray {
    // TC: O(n^2)
    // SC: O(1)
    public int maxProductBrute(int[] nums) {
        int n = nums.length;

        int res = 0;

        for(int L = 0; L < n; L++) {
            for(int R = L+1; R < n; R++) {

                int product = 1;
                for(int i = L; i <= R; i++) {
                    product *= nums[i];
                }

                res = Math.max(res, product);
            }
        }

        return res;
    }

    // TC: O(n)
    // SC: O(1)
    // dp top down
    public int maxProduct(int[] nums) {
        int curMax = 1, curMin = 1;

        int res = nums[0];

        // curMax, curMin = 1
        // for(int num : nums)
        // curMax = Math.max(curMax * num, curMin * num)
        // curMin = Math.min(curMax * num, curMin * num)

        // res = Math.max(res, curMax)

        for(int num : nums) {

            int tmpMax = Math.max(num, Math.max(curMax * num, curMin * num));
            curMin = Math.min(num, Math.min(curMax * num, curMin * num));

            curMax = tmpMax;

            res = Math.max(res, curMax);
        }

        return res;
    }
}
