/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.general.binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] test = new int[] { 0, 2, 3, 4, 7, 10 };
        System.out.println(contains(test, 8));
    }

    static boolean contains(int[] nums, int target) {
        int n = nums.length;
        int L = 0, R = n - 1;

        while( L <= R ) {
            int mid = L + (R-L)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] < target) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return false;
    }
}
