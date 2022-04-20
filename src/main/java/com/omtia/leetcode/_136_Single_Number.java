/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number/
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */

public class _136_Single_Number {
    // TC: O(n)
    // SC: O(n)
    public int singleNumber(int[] nums) {

        int a = 0;

        Set<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }

        return (int) set.toArray()[0];
    }

    // TC: O(n)
    // SC: O(1)
    public int singleNumber_v2(int[] nums) {
        int a = 0;

        for(int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }

        return a;
    }
}
