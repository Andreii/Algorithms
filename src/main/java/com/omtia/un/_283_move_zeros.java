/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero
 * elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
public class _283_move_zeros {
    public void moveZeroes(int[] nums) {
        int L = 0, R = 0;

        while(R < nums.length) {

            if(nums[R] != 0) {
                int z = nums[L];
                nums[L] = nums[R];
                nums[R] = z;
                L++;
            }

            R++;
        }
    }

    public void moveZeroes2(int[] nums) {

        int i = 0;
        for(int num : nums) {
            if(num != 0) {
                nums[i] = num;
                i++;
            }
        }

        for(; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes3(int[] nums) {
        // brute force
        int[] nums2 = new int[nums.length];

        int i = 0;
        for(int num : nums) {
            if(num != 0) {
                nums2[i] = num;
                i++;
            }
        }

        for(; i < nums.length; i++) {
            nums2[i] = 0;
        }

        for(int j = 0; j < nums.length; j++) {
            nums[j] = nums2[j];
        }
    }
}
