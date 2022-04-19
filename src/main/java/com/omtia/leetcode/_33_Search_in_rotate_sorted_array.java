package com.omtia.leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 */
public class _33_Search_in_rotate_sorted_array {
    // TC: O(log n)
    // SC: O(1)
    public int search(int[] nums, int target) {

        int n = nums.length;
        if(n == 0) return -1;

        int L = 0, R = n-1;
        int first = nums[0];

        while(L<=R) {
            int mid = L + (R-L)/2;
            int value = nums[mid];

            if(value == target) return mid;

            boolean am_big = value >= first;
            boolean target_big = target >= first;

            if(am_big == target_big) {
                if(value < target) {
                    L = mid+1;
                } else {
                    R = mid -1;
                }
            } else {
                if(am_big) {
                    L = mid+1;
                } else {
                    R = mid-1;
                }
            }
        }

        return -1;
    }
}
