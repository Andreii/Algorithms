package com.omtia.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class _3_Longest_substring_without_repeating_characters {
    // TC: O(n)
    // SC: O(min(m,n))
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        int size = 0, L = 0, R = 0;
        Set<Character> seen = new HashSet<>();

        while(R < s.length()) {
            if(!seen.contains(s.charAt(R))) {
                seen.add(s.charAt(R));
                R++;
            } else {
                seen.remove(s.charAt(L));
                L++;
            }

            size = Math.max(size, seen.size());
        }

        return size;
    }
}
