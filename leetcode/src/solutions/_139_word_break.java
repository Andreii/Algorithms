package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
public class _139_word_break {
    private static boolean dfs(String s, List<String> words, boolean[] visited, List<String> path) {
        if(s.equals(String.join("", path))) {
            return true;
        }

        for(int i = 0; i < words.size(); i++) {
            if(visited[i]) continue;

            visited[i] = true;
            path.add(words.get(i));

            if(dfs(s,words,visited,path)) return true;

            path.remove(path.size() -1);
            visited[i] = false;
        }
        return false;
    }

    private static boolean dfs(int i, Boolean[] memo, String s, List<String> words) {
        if(i == s.length()) return true;
        if(memo[i] != null) return memo[i];

        memo[i] = false;
        for(String word : words) {
            if(s.substring(i).startsWith(word)) {
                memo[i] = memo[i] || dfs(i + word.length(), memo, s, words);
            }
        }
        return memo[i];
    }

    public static boolean wordBreak(String s, List<String> words) {
        return dfs(s, words, new boolean[words.size()], new ArrayList<String>());
    }
}
