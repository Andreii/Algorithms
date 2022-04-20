/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 */
public class _215_kth_largest_element_in_an_array {
    // TC O(n log n)
    // SC O(1)
    // regular sort

    // TC O(n log n)
    // SC O(n)
    // PQ unbond
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return nums[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> b-a);

        for(int num : nums) {
            pq.offer(num);
        }

        int res = 0;
        for(int i = 0; i < k; i++) {
            res = pq.poll();
        }

        return res;
    }

    // TC O(n log k)
    // SC O(k)
    // PQ bound to k elements
    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return nums[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }

    // TC O(n) best - O(n^2) worst
    // SC O(1)
    // Quickselect

}