/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks,
 * return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where
 * the peak element is 6.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * nums[i] != nums[i + 1] for all valid i.
 */
public class _162_Find_peak_element {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        // [2,1]
        int L = 0, R = n-1;
        while(L < R) {
            int mid = L + (R-L) / 2;
            int val = nums[mid];
            int nextVal = nums[mid+1];
            if(val < nextVal) {
                L = mid+1;
            } else {
                R = mid;
            }
        }
        return L;
    }
}