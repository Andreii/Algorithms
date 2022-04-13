package un;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
 * 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class _42_trapping_rain_water {
    // TC: O(n)
    // SC: O(n)
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] fill = new int[n];

        int leftMax = 0, rightMax = 0;
        for(int l = 0, r = n-1; l < n; l++, r--) {
            leftMax = Math.max(leftMax, height[l]);
            left[l] = leftMax;

            rightMax = Math.max(rightMax, height[r]);
            right[r] = rightMax;
        }

        for(int i = 0; i < n; i++) {
            fill[i] = Math.min(left[i], right[i]);
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            res += fill[i] - height[i];
        }

        return res;
    }

    // TC: O(n)
    // SC: O(1)
    public int trap2(int[] height) {
        int n = height.length;
        int L = 0, R = n - 1;
        int left_max = 0, right_max = 0, res = 0;

        while(L < R) {
            if(height[L] <= height[R]) {
                left_max = Math.max(left_max, height[L]);
                res += left_max - height[L];
                L++;
            } else {
                right_max = Math.max(right_max, height[R]);
                res += right_max - height[R];
                R--;
            }
        }

        return res;
    }
}
