/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
public class _344_reverse_string {
    public void reverseString(char[] s) {
        // h e l l o
        // h e l l

        int n = s.length;

        for(int L = 0; L < n/2; L++) {
            int R = n - 1 - L;

            char z = s[L];
            s[L] = s[R];
            s[R] = z;
        }
    }
}
