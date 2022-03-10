package solutions;

/**
 * Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
 *
 *
 *
 * Example 1:
 *
 * Input: left = 5, right = 7
 * Output: 4
 * Example 2:
 *
 * Input: left = 0, right = 0
 * Output: 0
 * Example 3:
 *
 * Input: left = 1, right = 2147483647
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= left <= right <= 231 - 1
 */

public class _201_Bitwise_AND_of_Numbers_range {
    public int rangeBitwiseAnd(int left, int right) {
        // 001
        // 010
        // 011
        // 100
        // 101
        // 110
        // 111

        int ans = 0;
        for(int i = 30; i >= 0; i--) {
            if((left & (1<<i)) != (right & (1<<i))) {
                break;
            } else {
                ans |= (left & (1<<i));
            }
        }
        return ans;
    }
}
