/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer
 * in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
 * the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 */
public class _438_find_all_anagrams_in_a_string {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> p_map = new HashMap<>();

        for(char c : p.toCharArray()) {
            if(p_map.containsKey(c)) {
                p_map.put(c, p_map.get(c) + 1);
            } else {
                p_map.put(c, 1);
            }
        }

        HashMap<Character,Integer> p_try = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {

            Character c = s.charAt(i);

            if(p_try.containsKey(c)) {
                p_try.put(c, p_try.get(c) + 1);
            } else {
                p_try.put(c, 1);
            }

            if(i >= p.length()) {
                c = s.charAt(i - p.length());
                if(p_try.get(c) == 1) {
                    p_try.remove(c);
                } else {
                    p_try.put(c, p_try.get(c) - 1);
                }
            }

            if(p_try.equals(p_map)) res.add(i - p.length() + 1);
        }

        return res;
    }
}
