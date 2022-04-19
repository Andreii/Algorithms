package com.omtia.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
 * and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class _15_3sum {
    // sort
    // TC: O(n^2)
    // SC: O(log n) to O(n) -> depending on the implementation of the sorting algo
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length <= 1) return new ArrayList<>(0);
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
            int L = i + 1, R =  nums.length - 1;

            if(i != 0 && nums[i] == nums[i-1]) continue;

            while(L<R) {
                int sum = nums[i] + nums[L] + nums[R];
                if(sum < 0) {
                    L++;
                } else if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[L++], nums[R--]));
                    while(L<R && nums[L] == nums[L-1]) L++;
                } else {
                    R--;
                }
            }
        }
        return res;
    }

    // no sort
    // TC: O(n^2)
    // SC: O(n)
    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> res = new HashSet<>(0);
        if(nums.length <= 1) return new ArrayList(0);

        Set<Integer> dups = new HashSet<>();

        HashMap<Integer,Integer> visited = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            if(dups.add(nums[i])) {
                for(int j = i + 1; j < nums.length; j++) {
                    int R =  -nums[i] - nums[j];
                    if(visited.containsKey(R) && visited.get(R) == i) {
                        List<Integer> found = Arrays.asList(nums[i], nums[j], R);
                        Collections.sort(found);
                        res.add(found);
                    }
                    visited.put(nums[j], i);
                }
            }
        }

        return new ArrayList(res);
    }
}
