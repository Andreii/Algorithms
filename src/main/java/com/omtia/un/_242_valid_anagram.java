/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
 * the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class _242_valid_anagram {

    // TC: O(nlogn)
    // SC: O(1)
    // sort
    public boolean isAnagramSort(String s, String t) {
        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();

        Arrays.sort(s_chars);
        Arrays.sort(t_chars);

        return Arrays.equals(s_chars, t_chars);
    }

    // TC: O(n) -> where n is length of longest string
    // SC: O(n)
    // work with all unicode
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(char c : t.toCharArray()) {
            if(!map.containsKey(c)) return false;

            int newVal = map.get(c)-1;

            if(newVal < 0) return false;

            map.put(c, newVal);
        }

        for(Integer val : map.values()) {
            if (val > 0) return false;
        }

        return true;
    }

    // TC: O(n) -> where n is length of longest string
    // SC: O(1)
    public boolean isAnagramChars(String s, String t) {
        short[] map = new short[26];

        for(char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        for(char c : t.toCharArray()) {
            map[c - 'a']--;
            if(map[c - 'a'] < 0) return false;
        }

        for(int count : map) {
            if(count != 0) return false;
        }

        return true;
    }
}
