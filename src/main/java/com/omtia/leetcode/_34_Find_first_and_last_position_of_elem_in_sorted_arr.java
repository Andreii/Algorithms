/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.leetcode;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given
 * target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class _34_Find_first_and_last_position_of_elem_in_sorted_arr {
    public enum Range {MIN,MAX}
    // TC: O(n)
    // SC: O(1)
    public int binary(int[] nums, int target, Range range) {
        int index = -1;
        int n = nums.length;
        int L = 0, R = n-1;
        while(L<=R) {
            int mid = L + (R-L)/2;
            if(range == Range.MIN) {
                if(nums[mid] >= target) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            } else {
                if(nums[mid] <= target) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }

            if(nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = binary(nums, target, Range.MIN);
        ans[1] = binary(nums, target, Range.MAX);
        return ans;
    }
}
