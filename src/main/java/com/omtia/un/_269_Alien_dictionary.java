/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

/*
 * @author Andrei Constantin Tanasache, act@omtia.com
 */

package com.omtia.un;

import java.util.*;

/**
 * There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
 *
 * You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted
 * lexicographically by the rules of this new language.
 *
 * Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the
 * new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.
 *
 * A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s
 * comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same,
 * then s is smaller if and only if s.length < t.length.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * Example 2:
 *
 * Input: words = ["z","x"]
 * Output: "zx"
 * Example 3:
 *
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of only lowercase English letters.
 */
public class _269_Alien_dictionary {
    public static void main(String[] args) {
        _269_Alien_dictionary c = new _269_Alien_dictionary();

        System.out.println(c.alienOrder(new String[] { "wrt","wrf","er","ett","rftt"}));
    }

    public String alienOrder(String[] words) {
        Map<Character,List<Character>> adj = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();
        LinkedList<Character> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                adj.put(c, new ArrayList<>());
                indegree.put(c,0);
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];

            if(w1.length() > w2.length() && w1.startsWith(w2)) return "";

            for(int j = 0; j < Math.min(w1.length(),w2.length()); j++) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    Character w1c = w1.charAt(j);
                    Character w2c = w2.charAt(j);

                    adj.get(w1c).add(w2c);
                    indegree.put(w2c, indegree.get(w2c) + 1);
                    break;
                }
            }
        }

        for(Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if(entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        while(!q.isEmpty()) {
            Character u = q.pop();
            res.append(String.valueOf(u));

            for(Character v : adj.get(u)) {
                indegree.put(v, indegree.get(v) - 1);
                if(indegree.get(v).equals(0)) {
                    q.add(v);
                }
            }
        }

        if(res.length() != indegree.size()) return "";

        return res.toString();
    }
}
