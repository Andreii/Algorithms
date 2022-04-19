package com.omtia.leetcode;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
 * character in t (including duplicates) is included in the window. If there is no such substring, return the empty
 * string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class _76_minimum_window_substring {
    // TC: O(|S| + |T|)
    // SC: O(|S| + |T|)
    public String minWindow(String s, String t) {
        int[] chars = new int[128];
        for(int c : t.toCharArray()) {
            chars[c]++;
        }

        int L = 0, R = 0, minStart = 0, minLength = Integer.MAX_VALUE, counter = t.length();

        while(R < s.length()) {
            char c1 = s.charAt(R);
            if(chars[c1] > 0) counter --;
            chars[c1]--;
            R++;

            while(counter == 0) {
                if(minLength > R - L) {
                    minLength = R - L;
                    minStart = L;
                }

                char c2 = s.charAt(L);
                chars[c2]++;
                if(chars[c2]>0) counter++;
                L++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
