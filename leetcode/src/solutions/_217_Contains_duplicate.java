package solutions;

import java.util.*;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every
 *  element is distinct.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

public class _217_Contains_duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();

        int n = nums.length;
        for(int i = 0; i < n ; i++) {
            if(visited.contains(nums[i])) return true;
            visited.add(nums[i]);
        }
        return false;
    }
}
