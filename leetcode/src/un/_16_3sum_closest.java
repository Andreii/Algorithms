package un;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is
 * closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class _16_3sum_closest {
    public int threeSumClosest(int[] nums, int target) {
        int delta = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            int L = i+1, R = nums.length - 1;

            while(L<R) {
                int sum = nums[i] + nums[L] + nums[R];

                if(Math.abs(target-sum) < Math.abs(delta)) {
                    delta = target - sum;
                }

                if(sum < target) {
                    L++;
                } else {
                    R--;
                }
            }
        }

        return target - delta;
    }
}
