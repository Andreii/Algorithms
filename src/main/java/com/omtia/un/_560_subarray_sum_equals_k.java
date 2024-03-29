/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class _560_subarray_sum_equals_k {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;

        for(int i = 0; i<n; i++) {
            sum += nums[i];
            int compl = sum - k;

            if(map.containsKey(compl)) {
                count += map.get(compl);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
