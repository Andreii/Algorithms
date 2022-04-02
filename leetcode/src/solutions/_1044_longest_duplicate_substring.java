package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times.
 * The occurrences may overlap.
 *
 * Return any duplicated substring that has the longest possible length. If s does not have a duplicated substring,
 * the answer is "".
 *
 *
 *
 * Example 1:
 *
 * Input: s = "banana"
 * Output: "ana"
 * Example 2:
 *
 * Input: s = "abcd"
 * Output: ""
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 3 * 104
 * s consists of lowercase English letters.
 */
public class _1044_longest_duplicate_substring {
    public String longestDupSubstring(String s) {
        String res = "";
        int L = 1, R = s.length();

        while(L<=R) {
            int M = L + (R-L)/2;

            String dupl = getDuplicate(s, M);
            int dl = dupl.length(), rl = res.length();

            if(!dupl.equals("")) {
                res = dupl;
                L = M+1;
            } else {
                R = M-1;
            }
        }

        return res;
    }

    public String getDuplicate(String s, int M) {
        Set<String> visited = new HashSet<>();

        for(int i = 0; i < s.length() - M + 1; i++) {
            String try_s = s.substring(i, i+M);
            if(!visited.contains(try_s)) {
                visited.add(try_s);
            } else {
                return try_s;
            }
        }

        return "";
    }
}
